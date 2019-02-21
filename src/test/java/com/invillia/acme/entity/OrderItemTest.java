package com.invillia.acme.entity;

import com.invillia.acme.test.suport.ModelEntityTest;
import com.invillia.acme.test.data.factory.OrderItemTestDataFactory;

/**
 * OrderItem entity unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class OrderItemTest extends ModelEntityTest<OrderItem> {

    public OrderItemTest() {
        super(new OrderItemTestDataFactory());
    }

}
