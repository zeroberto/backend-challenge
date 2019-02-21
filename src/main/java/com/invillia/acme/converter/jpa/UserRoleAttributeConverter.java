package com.invillia.acme.converter.jpa;

import com.invillia.acme.enums.UserRole;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

/**
 * Jpa Converter for UserRole objects.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Converter
public class UserRoleAttributeConverter implements AttributeConverter<UserRole, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserRole userRole) {
        return Objects.nonNull(userRole) ? userRole.getValue() : null;
    }

    @Override
    public UserRole convertToEntityAttribute(Integer value) {
        return Objects.nonNull(value) ? UserRole.valueOf(value) : null;
    }

}
