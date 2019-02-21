package com.invillia.acme.repository;

import com.invillia.acme.entity.OrderItem;
import com.invillia.acme.test.data.factory.OrderItemTestDataFactory;
import com.invillia.acme.test.data.factory.OrderTestDataFactory;
import com.invillia.acme.test.suport.ModelRepositoryIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * OrderItem repository integration test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class OrderItemRepositoryTest extends ModelRepositoryIntegrationTest<OrderItem, OrderItemRepository> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderItem createModelEntity() {
        OrderItem orderItem = new OrderItemTestDataFactory().createNew();
        // Save an order
        orderItem.setOrder(orderRepository.save(new OrderTestDataFactory().createNew()));
        return orderItem;
    }

}
