package com.invillia.acme.service;

import com.invillia.acme.entity.OrderItem;
import com.invillia.acme.repository.OrderItemRepository;
import com.invillia.acme.test.data.factory.OrderItemTestDataFactory;
import com.invillia.acme.test.suport.ModelServiceTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * OrderItem service unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class OrderItemServiceTest extends ModelServiceTest<OrderItem, OrderItemRepository, OrderItemService> {

    @InjectMocks
    private OrderItemService service;

    @Mock
    private OrderItemRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Override
    protected OrderItem createEntity() {
        return new OrderItemTestDataFactory().create();
    }

    @Override
    protected OrderItemRepository getRepository() {
        return this.repository;
    }

    @Override
    protected OrderItemService getService() {
        return this.service;
    }

}
