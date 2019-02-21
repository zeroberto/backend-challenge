package com.invillia.acme.test.data.factory;

import com.invillia.acme.entity.Store;

/**
 * Store test data factory class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class StoreTestDataFactory implements TestDataFactory<Store> {

    public static final Long VALID_ID = 1L;
    public static final String VALID_ADDRESS = "Anyone";
    public static final String VALID_NAME = "Any";

    public static final Long INVALID_ID = -1L;
    public static final String INVALID_NAME = "";
    public static final String INVALID_ADDRESS = "";

    @Override
    public Store createNew() {
        Store store = new Store();
        store.setName(VALID_NAME);
        store.setAddress(VALID_ADDRESS);
        return store;
    }

    @Override
    public Store create() {
        Store store = createNew();
        store.setId(VALID_ID);
        return store;
    }

    @Override
    public Store createNewInvalid() {
        Store store = new Store();
        store.setName(INVALID_NAME);
        store.setAddress(INVALID_ADDRESS);
        return store;
    }

    @Override
    public Store createInvalid() {
        Store store = createNewInvalid();
        store.setId(INVALID_ID);
        return store;
    }

}
