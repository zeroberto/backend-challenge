package com.invillia.acme.repository;

import com.invillia.acme.entity.Order;
import com.invillia.acme.test.data.factory.OrderTestDataFactory;
import com.invillia.acme.test.suport.ModelRepositoryIntegrationTest;

/**
 * Order repository integration test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class OrderRepositoryTest extends ModelRepositoryIntegrationTest<Order, OrderRepository> {
    @Override
    public Order createModelEntity() {
        return new OrderTestDataFactory().createNew();
    }
}
