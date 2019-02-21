package com.invillia.acme.repository;

import com.invillia.acme.core.model.ModelRepository;
import com.invillia.acme.entity.Store;

import java.util.Optional;

/**
 * Store entity repository.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public interface StoreRepository extends ModelRepository<Store> {

    /**
     * Method to get a store by name.
     *
     * @param name Desired store name.
     * @return Store found.
     */
    Optional<Store> findByName(String name);

}