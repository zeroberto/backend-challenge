package com.invillia.acme.http.gateway;

import com.invillia.acme.core.gateway.ServiceGateway;
import com.invillia.acme.dto.OrderItemDTO;
import com.invillia.acme.entity.OrderItem;
import com.invillia.acme.repository.OrderItemRepository;
import com.invillia.acme.service.OrderItemService;
import org.springframework.stereotype.Component;

/**
 * OrderItem service gateway class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Component
public class OrderItemGateway extends ServiceGateway<OrderItemDTO, OrderItem, OrderItemRepository, OrderItemService> {

    public OrderItemGateway() {
        super(OrderItemDTO.class);
    }

}
