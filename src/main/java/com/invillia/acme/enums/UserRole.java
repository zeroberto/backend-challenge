package com.invillia.acme.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * Enum containing the permissions types of the application.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Getter
public enum UserRole {

    /**
     * Permission type for admin users.
     */
    ADMIN(0),

    /**
     * Permission type for ordinary users.
     */
    USER(1),

    /**
     * Permission type for sellers.
     */
    SELLER(2);

    public static final String ROLE_PREFIX = "ROLE_";

    private int value;

    UserRole(int value) {
        this.value = value;
    }

    /**
     * Obtain an UserRole according to an informed role.
     *
     * @param value Value of UserRole.
     * @return UserRole found.
     */
    public static UserRole valueOf(Integer value) {
        return Arrays.stream(values())
                .filter(userRole -> userRole.value == value)
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtain a role name with prefix.
     *
     * @return Role name.
     */
    public String roleName() {
        return ROLE_PREFIX + name();
    }

}
