package com.invillia.acme.entity;

import com.invillia.acme.enums.OrderStatus;
import com.invillia.acme.test.suport.ModelEntityTest;
import com.invillia.acme.test.data.factory.OrderTestDataFactory;
import org.junit.jupiter.api.Test;

import static com.invillia.acme.test.data.factory.OrderTestDataFactory.NONEXISTENT_STATUS;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Order entity unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class OrderTest extends ModelEntityTest<Order> {

    public OrderTest() {
        super(new OrderTestDataFactory());
    }

    @Test
    void givenAnOrder_whenStatusInvalid_thenThrowsExceptionFailure() {
        Order order = getTestDataFactory().create();
        assertThrows(IllegalArgumentException.class, () -> order.setStatus(OrderStatus.valueOf(NONEXISTENT_STATUS)));
    }

}
