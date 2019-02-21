package com.invillia.acme.test.suport;

import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Validator unit test class suite.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Getter
public abstract class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

}
