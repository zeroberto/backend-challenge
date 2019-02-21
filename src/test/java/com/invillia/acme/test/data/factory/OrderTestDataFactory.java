package com.invillia.acme.test.data.factory;

import com.invillia.acme.entity.Order;
import com.invillia.acme.enums.OrderStatus;

import java.time.LocalDateTime;

/**
 * Order test data factory class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class OrderTestDataFactory implements TestDataFactory<Order> {

    public static final Long VALID_ID = 1L;
    public static final String VALID_ADDRESS = "Any street, no number.";
    public static final LocalDateTime VALID_CONFIRMATION_DATE = LocalDateTime.now();
    public static final String VALID_STATUS = "CREATED";

    public static final Long INVALID_ID = -1L;
    public static final String INVALID_ADDRESS = "";
    public static final LocalDateTime INVALID_CONFIRMATION_DATE = null;
    public static final OrderStatus INVALID_STATUS = null;
    public static final String NONEXISTENT_STATUS = "";

    @Override
    public Order createNew() {
        Order order = new Order();
        order.setAddress(VALID_ADDRESS);
        order.setConfirmationDate(VALID_CONFIRMATION_DATE);
        order.setStatus(OrderStatus.valueOf(VALID_STATUS));
        return order;
    }

    @Override
    public Order create() {
        Order order = createNew();
        order.setId(VALID_ID);
        return order;
    }

    @Override
    public Order createNewInvalid() {
        Order order = new Order();
        order.setAddress(INVALID_ADDRESS);
        order.setConfirmationDate(INVALID_CONFIRMATION_DATE);
        order.setStatus(INVALID_STATUS);
        return order;
    }

    @Override
    public Order createInvalid() {
        Order order = createNewInvalid();
        order.setId(INVALID_ID);
        return order;
    }

}
