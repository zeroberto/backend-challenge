package com.invillia.acme.http.gateway;

import com.invillia.acme.core.gateway.ServiceGateway;
import com.invillia.acme.dto.StoreDTO;
import com.invillia.acme.entity.Store;
import com.invillia.acme.repository.StoreRepository;
import com.invillia.acme.service.StoreService;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Store service gateway class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Component
public class StoreGateway extends ServiceGateway<StoreDTO, Store, StoreRepository, StoreService> {

    public StoreGateway() {
        super(StoreDTO.class);
    }

    /**
     * Method for searching for a name.
     *
     * @param name Desired store name.
     * @return A CompletableFuture containing the requested store.
     */
    public Future<StoreDTO> findByName(String name) {
        Store modelEntity = getService().findByName(name);
        return CompletableFuture.completedFuture(
                getModelMapper().map(modelEntity, getDtoClassType())
        );
    }

}
