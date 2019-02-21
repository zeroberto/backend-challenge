package com.invillia.acme.http.gateway;

import com.invillia.acme.core.gateway.ServiceGateway;
import com.invillia.acme.dto.OrderDTO;
import com.invillia.acme.dto.PaymentDTO;
import com.invillia.acme.entity.Order;
import com.invillia.acme.entity.Payment;
import com.invillia.acme.repository.OrderRepository;
import com.invillia.acme.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Order service gateway class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Component
public class OrderGateway extends ServiceGateway<OrderDTO, Order, OrderRepository, OrderService> {

    public OrderGateway() {
        super(OrderDTO.class);
    }

    /**
     * Method to make a payment.
     *
     * @param id         Desired order identification.
     * @param requestDTO PaymentDTO object with payment data.
     * @return A CompletableFuture containing the updated order.
     */
    public Future<OrderDTO> pay(Long id, PaymentDTO requestDTO) {
        Order order = getService().pay(id, getModelMapper().map(requestDTO, Payment.class));
        return CompletableFuture.completedFuture(
                getModelMapper().map(order, OrderDTO.class)
        );
    }

    /**
     * Method to make a payment.
     *
     * @param id Desired order identification.
     * @return A CompletableFuture containing the updated order.
     */
    public Future<OrderDTO> refund(Long id) {
        Order order = getService().refund(id);
        return CompletableFuture.completedFuture(
                getModelMapper().map(order, OrderDTO.class)
        );
    }

}
