package com.invillia.acme.enums;

import org.junit.jupiter.api.Test;

import static com.invillia.acme.test.data.factory.OrderTestDataFactory.NONEXISTENT_STATUS;
import static com.invillia.acme.test.data.factory.OrderTestDataFactory.VALID_STATUS;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * OrderStatus enum unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class OrderStatusTest {

    @Test
    void givenAnString_whenExistsAnEquivalentOrderStatus_thenValueOfSuccess() {
        assertNotNull(OrderStatus.valueOf(VALID_STATUS));
    }

    @Test
    void givenAnString_whenNotExistsAnEquivalentOrderStatus_thenValueOfFailure() {
        assertThrows(IllegalArgumentException.class, () -> OrderStatus.valueOf(NONEXISTENT_STATUS));
    }

}
