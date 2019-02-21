package com.invillia.acme.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * Enum responsible for representing the possible status types for an Order.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Getter
public enum OrderStatus {

    /**
     * Indicates that the order has been created.
     */
    CREATED(0),

    /**
     * Indicates that the order is awaiting confirmation of payment.
     */
    WAITING_FOR_PAYMENT_CONFIRMATION(1),

    /**
     * Indicates that the order is completed.
     */
    FINALIZED(2),

    /**
     * Indicates that the order is refunded for a payment.
     */
    REFUNDED(3);

    private int value;

    OrderStatus(int value) {
        this.value = value;
    }

    /**
     * Obtain an OrderStatus according to an informed status.
     *
     * @param value Value of OrderStatus.
     * @return OrderStatus found.
     */
    public static OrderStatus valueOf(Integer value) {
        return Arrays.stream(values())
                .filter(orderStatus -> orderStatus.value == value)
                .findFirst()
                .orElse(null);
    }

}
