package com.invillia.acme.converter.jpa;

import com.invillia.acme.enums.OrderStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

/**
 * Jpa Converter for OrderStatus objects.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Converter
public class OrderStatusAttributeConverter implements AttributeConverter<OrderStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderStatus orderStatus) {
        return Objects.nonNull(orderStatus) ? orderStatus.getValue() : null;
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer value) {
        return Objects.nonNull(value) ? OrderStatus.valueOf(value) : null;
    }

}
