package com.invillia.acme.core.model;

import com.invillia.acme.exceptions.InvalidIdentifierException;
import com.invillia.acme.exceptions.ModelEntityNotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static com.invillia.acme.core.utils.ExceptionUtils.orElseThrows;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Generic service class containing methods common to most model services.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public abstract class ModelService<ME extends ModelEntity, MR extends ModelRepository<ME>> {

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private MR repository;

    @Getter
    private final Class<ME> entityType;

    public ModelService(Class<ME> entityType) {
        this.entityType = entityType;
    }

    /**
     * Method to save an entity, ignoring id.
     *
     * @param entity Entity to persist.
     * @return The entity itself.
     */
    public ME save(ME entity) {
        return persist(entity, true);
    }

    /**
     * Method to save (update) an entity, considering id.
     *
     * @param entity Entity to persist.
     * @return The entity itself.
     */
    public ME update(ME entity) {
        return persist(entity, false);
    }

    /**
     * Method for searching for an entity.
     *
     * @param id Entity identifier.
     * @return Desired entity.
     */
    public ME find(Long id) {
        try {
            orElseThrows(isNull(id), new InvalidIdentifierException());
            Optional<ME> optionalEntity = getRepository().findById(id);
            return optionalEntity.orElseThrow(() -> new ModelEntityNotFoundException(getEntityType()));
        } catch (EntityNotFoundException ex) {
            throw new ModelEntityNotFoundException(getEntityType());
        }
    }

    /**
     * Method to remove a certain object of the type of entity you want.
     *
     * @param id Desired entity identification.
     * @return The entity itself removed.
     */
    public ME delete(Long id) {
        ME foundEntity = find(id);
        getRepository().delete(foundEntity);
        return foundEntity;
    }

    /**
     * Method for obtaining a list of objects of the type of entity you want.
     *
     * @return Collection of the desired entity.
     */
    public List<ME> list() {
        return getRepository().findAll();
    }

    /**
     * Method to save an entity.
     *
     * @param entity         Entity to persist.
     * @param ignoreIdExists Defines that if the id is present, it must be ignored.
     * @return The entity itself.
     */
    private ME persist(ME entity, boolean ignoreIdExists) {
        if (!ignoreIdExists && nonNull(entity) && !entity.isNew()) {
            orElseThrows(!getRepository().existsById(entity.getId()), new ModelEntityNotFoundException(getEntityType()));
        } else {
            entity.setId(null);
        }
        return getRepository().save(entity);
    }

}