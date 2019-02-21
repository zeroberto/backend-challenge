package com.invillia.acme.service;

import com.invillia.acme.core.exceptions.ApplicationException;
import com.invillia.acme.core.model.ModelService;
import com.invillia.acme.entity.Order;
import com.invillia.acme.entity.Payment;
import com.invillia.acme.enums.OrderStatus;
import com.invillia.acme.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.invillia.acme.constants.BusinessRulesConstants.REFUND_LIMIT_DAYS;
import static com.invillia.acme.core.utils.ExceptionUtils.orElseThrows;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Order service class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Service
public class OrderService extends ModelService<Order, OrderRepository> {

    public OrderService() {
        super(Order.class);
    }

    /**
     * Method of making an order payment.
     *
     * @param id      Desired order identification.
     * @param payment Payment information.
     * @return A payed order.
     */
    public Order pay(Long id, Payment payment) {
        Order order = find(id);
        if (nonNull(order.getPayment())) {
            throw new ApplicationException("{entity.order.service.payment.already_been_done}");
        }
        order.setPayment(payment);
        order.setStatus(OrderStatus.FINALIZED);
        update(order);
        return order;
    }

    /**
     * Method for making a refund for an order.
     *
     * @param id The desired order identification.
     * @return The refunded order.
     */
    public Order refund(Long id) {
        Order order = find(id);
        orElseThrows(isNull(order.getPayment()), new ApplicationException("{entity.order.service.payment.no_payment}"));
        orElseThrows(
                order.getConfirmationDate().plus(REFUND_LIMIT_DAYS, ChronoUnit.DAYS).isBefore(LocalDateTime.now()),
                new ApplicationException("{entity.order.service.deadline_expired}")
        );
        order.setStatus(OrderStatus.REFUNDED);
        update(order);
        return order;
    }

}