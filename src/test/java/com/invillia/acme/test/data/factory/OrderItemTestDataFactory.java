package com.invillia.acme.test.data.factory;

import com.invillia.acme.entity.OrderItem;

import java.math.BigDecimal;

/**
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class OrderItemTestDataFactory implements TestDataFactory<OrderItem> {

    public static final Long VALID_ID = 1L;
    public static final String VALID_DESCRIPTION = "Anyone";
    public static final BigDecimal VALID_QUANTITY = new BigDecimal(1);
    public static final BigDecimal VALID_UNIT_PRICE = new BigDecimal(1);

    public static final Long INVALID_ID = 1L;
    public static final String INVALID_DESCRIPTION = null;
    public static final BigDecimal INVALID_QUANTITY = new BigDecimal(0);
    public static final BigDecimal INVALID_UNIT_PRICE = new BigDecimal(-1);

    @Override
    public OrderItem createNew() {
        OrderItem orderItem = new OrderItem();
        orderItem.setDescription(VALID_DESCRIPTION);
        orderItem.setQuantity(VALID_QUANTITY);
        orderItem.setUnitPrice(VALID_UNIT_PRICE);
        return orderItem;
    }

    @Override
    public OrderItem create() {
        OrderItem orderItem = createNew();
        orderItem.setId(VALID_ID);
        return orderItem;
    }

    @Override
    public OrderItem createNewInvalid() {
        OrderItem orderItem = new OrderItem();
        orderItem.setDescription(INVALID_DESCRIPTION);
        orderItem.setQuantity(INVALID_QUANTITY);
        orderItem.setUnitPrice(INVALID_UNIT_PRICE);
        return orderItem;
    }

    @Override
    public OrderItem createInvalid() {
        OrderItem orderItem = createNewInvalid();
        orderItem.setId(INVALID_ID);
        return orderItem;
    }

}
