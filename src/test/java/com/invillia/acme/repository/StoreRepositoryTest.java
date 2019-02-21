package com.invillia.acme.repository;

import com.invillia.acme.entity.Store;
import com.invillia.acme.test.data.factory.StoreTestDataFactory;
import com.invillia.acme.test.suport.ModelRepositoryIntegrationTest;

/**
 * Store repository integration test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class StoreRepositoryTest extends ModelRepositoryIntegrationTest<Store, StoreRepository> {

    @Override
    public Store createModelEntity() {
        return new StoreTestDataFactory().createNew();
    }

}
