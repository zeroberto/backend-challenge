package com.invillia.acme.converter.jpa;

import com.invillia.acme.enums.UserRole;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * UserRoleAttributeConverter unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class UserRoleAttributeConverterTest {

    @Test
    void givenAValidUserRole_whenIsAValidIntegerValue_thenConvertSuccess() {
        // Given
        UserRole userRole = Arrays.stream(UserRole.values()).findAny().orElse(null);
        // When
        Integer value = Objects.requireNonNull(userRole).getValue();
        // Then
        assertEquals(userRole, new UserRoleAttributeConverter().convertToEntityAttribute(value));
    }

    @Test
    void whenIsAnInvalidIntegerValue_thenConvertFailure() {
        // When
        Integer value = -1;
        // Then
        assertNull(new UserRoleAttributeConverter().convertToEntityAttribute(value));
    }

    @Test
    void givenAValidIntegerValue_whenIsAValidUserRole_thenConvertSuccess() {
        // Given
        Integer value = Objects.requireNonNull(Arrays.stream(UserRole.values()).findAny().orElse(null)).getValue();
        // When
        UserRole userRole = UserRole.valueOf(value);
        // Then
        assertEquals(value, new UserRoleAttributeConverter().convertToDatabaseColumn(userRole));
    }

    @Test
    void whenIsAnInvalidUserRole_thenConvertFailure() {
        assertNull(new UserRoleAttributeConverter().convertToDatabaseColumn(null));
    }

}
