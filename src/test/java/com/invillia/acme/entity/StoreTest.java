package com.invillia.acme.entity;

import com.invillia.acme.test.suport.ModelEntityTest;
import com.invillia.acme.test.data.factory.StoreTestDataFactory;

/**
 * Store entity unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class StoreTest extends ModelEntityTest<Store> {

    public StoreTest() {
        super(new StoreTestDataFactory());
    }

}
