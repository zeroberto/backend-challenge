package com.invillia.acme.service;

import com.invillia.acme.core.model.ModelService;
import com.invillia.acme.entity.Store;
import com.invillia.acme.exceptions.InvalidIdentifierException;
import com.invillia.acme.exceptions.ModelEntityNotFoundException;
import com.invillia.acme.repository.StoreRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static com.invillia.acme.core.utils.ExceptionUtils.orElseThrows;
import static java.util.Objects.isNull;

/**
 * Store service class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Service
public class StoreService extends ModelService<Store, StoreRepository> {

    public StoreService() {
        super(Store.class);
    }


    /**
     * Method for searching for an store by name.
     *
     * @param name Store name.
     * @return Desired Store.
     */
    public Store findByName(String name) {
        try {
            orElseThrows(isNull(name), new InvalidIdentifierException());
            Optional<Store> optionalEntity = getRepository().findByName(name);
            return optionalEntity.orElseThrow(() -> new ModelEntityNotFoundException(getEntityType()));
        } catch (EntityNotFoundException ex) {
            throw new ModelEntityNotFoundException(getEntityType());
        }
    }

}