package com.invillia.acme.repository;

import com.invillia.acme.core.model.ModelRepository;
import com.invillia.acme.entity.Order;
import com.invillia.acme.entity.OrderItem;

import java.util.List;

/**
 * Order Item entity repository.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public interface OrderItemRepository extends ModelRepository<OrderItem> {

    /**
     * Find order items by order.
     *
     * @param order Desired order.
     * @return Collection of order items.
     */
    List<OrderItem> findAllByOrder(Order order);

}