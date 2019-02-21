package com.invillia.acme.converter.jpa;

import com.invillia.acme.converter.jpa.OrderStatusAttributeConverter;
import com.invillia.acme.enums.OrderStatus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * OrderStatusAttributeConverter unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class OrderStatusAttributeConverterTest {

    @Test
    void givenAValidOrderStatus_whenIsAValidIntegerValue_thenConvertSuccess() {
        // Given
        OrderStatus orderStatus = Arrays.stream(OrderStatus.values()).findAny().orElse(null);
        // When
        Integer value = Objects.requireNonNull(orderStatus).getValue();
        // Then
        assertEquals(orderStatus, new OrderStatusAttributeConverter().convertToEntityAttribute(value));
    }

    @Test
    void whenIsAnInvalidIntegerValue_thenConvertFailure() {
        // When
        Integer value = -1;
        // Then
        assertNull(new OrderStatusAttributeConverter().convertToEntityAttribute(value));
    }

    @Test
    void givenAValidIntegerValue_whenIsAValidOrderStatus_thenConvertSuccess() {
        // Given
        Integer value = Objects.requireNonNull(Arrays.stream(OrderStatus.values()).findAny().orElse(null)).getValue();
        // When
        OrderStatus orderStatus = OrderStatus.valueOf(value);
        // Then
        assertEquals(value, new OrderStatusAttributeConverter().convertToDatabaseColumn(orderStatus));
    }

    @Test
    void whenIsAnInvalidOrderStatus_thenConvertFailure() {
        assertNull(new OrderStatusAttributeConverter().convertToDatabaseColumn(null));
    }

}
