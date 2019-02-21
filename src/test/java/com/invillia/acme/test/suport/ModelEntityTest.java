package com.invillia.acme.test.suport;

import com.invillia.acme.core.model.ModelEntity;
import com.invillia.acme.test.data.factory.TestDataFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ModelEntity unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@RequiredArgsConstructor
@Getter
public abstract class ModelEntityTest<ME extends ModelEntity> extends ValidatorTest {

    private final TestDataFactory<ME> testDataFactory;

    @Test
    void givenAValidEntity_whenToValidate_thenSuccess() {
        ME modelEntity = testDataFactory.create();
        Set<ConstraintViolation<ModelEntity>> violations = getValidator().validate(modelEntity);
        assertTrue(violations.isEmpty());
    }

    @Test
    void givenAInvalidEntity_whenToValidate_thenFailure() {
        ME modelEntity = testDataFactory.createInvalid();
        Set<ConstraintViolation<ModelEntity>> violations = getValidator().validate(modelEntity);
        assertFalse(violations.isEmpty());
    }

}