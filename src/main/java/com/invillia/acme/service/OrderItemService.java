package com.invillia.acme.service;

import com.invillia.acme.core.model.ModelService;
import com.invillia.acme.entity.OrderItem;
import com.invillia.acme.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

/**
 * OrderItem service class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Service
public class OrderItemService extends ModelService<OrderItem, OrderItemRepository> {

    public OrderItemService() {
        super(OrderItem.class);
    }

}