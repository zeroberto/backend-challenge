package com.invillia.acme.converter.jpa;

import com.invillia.acme.converter.jpa.LocalDateTimeAttributeConverter;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * LocalDateTimeAttributeConverter unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class LocalDateTimeAttributeConverterTest {

    @Test
    void givenAValidLocalDateTime_whenIsAValidTimestamp_thenConvertSuccess() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.now();
        // When
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        // Then
        assertEquals(localDateTime, new LocalDateTimeAttributeConverter().convertToEntityAttribute(timestamp));
    }

    @Test
    void whenIsAnInvalidTimestampValue_thenConvertFailure() {
        assertNull(new LocalDateTimeAttributeConverter().convertToEntityAttribute(null));
    }

    @Test
    void givenAValidTimestampValue_whenIsAValidLocalDateTime_thenConvertSuccess() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.now();
        // When
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        // Then
        assertEquals(timestamp, new LocalDateTimeAttributeConverter().convertToDatabaseColumn(localDateTime));
    }

    @Test
    void whenIsAnInvalidLocalDateTime_thenConvertFailure() {
        assertNull(new LocalDateTimeAttributeConverter().convertToDatabaseColumn(null));
    }

}
