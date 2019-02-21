package com.invillia.acme.enums;

import org.junit.jupiter.api.Test;

import static com.invillia.acme.test.data.factory.OrderTestDataFactory.NONEXISTENT_STATUS;
import static com.invillia.acme.test.data.factory.OrderTestDataFactory.VALID_STATUS;
import static com.invillia.acme.test.data.factory.UserTestDataFactory.INVALID_USER_ROLE;
import static com.invillia.acme.test.data.factory.UserTestDataFactory.VALID_USER_ROLE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * UserRole enum unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class UserRoleTest {

    @Test
    void givenAnString_whenExistsAnEquivalentUserRole_thenValueOfSuccess() {
        assertNotNull(UserRole.valueOf(VALID_USER_ROLE));
    }

    @Test
    void givenAnString_whenNotExistsAnEquivalentUserRole_thenValueOfFailure() {
        assertThrows(IllegalArgumentException.class, () -> UserRole.valueOf(INVALID_USER_ROLE));
    }

}
