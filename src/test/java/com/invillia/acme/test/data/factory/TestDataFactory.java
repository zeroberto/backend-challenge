package com.invillia.acme.test.data.factory;

import com.invillia.acme.core.model.ModelEntity;

/**
 * Data factory super class for tests.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public interface TestDataFactory<ME extends ModelEntity> {

    ME createNew();

    ME create();

    ME createNewInvalid();

    ME createInvalid();

}
