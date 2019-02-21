package com.invillia.acme.constants;

import com.invillia.acme.enums.UserRole;

/**
 * Class containing the constants related to business rules.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public final class BusinessRulesConstants {

    /**
     * Minimum value for a quantity.
     */
    public static final long ORDER_ITEM_QUANTITY_MIN = 1L;

    /**
     * Minimum value for a unit price.
     */
    public static final long ORDER_ITEM_UNIT_PRICE_MIN = 0L;

    /**
     * Size value for a card number.
     */
    public static final int PAYMENT_CARD_NUMBER_SIZE = 16;

    /**
     * Min Size value for an any String.
     */
    public static final int DEFAULT_STRING_MIN_SIZE = 1;

    /**
     * Max Size value for an any String.
     */
    public static final int DEFAULT_STRING_MAX_SIZE = 255;

    /**
     * Pattern value for a card number.
     */
    public static final String PAYMENT_CARD_NUMBER_PATTERN = "[\\d]+";

    /**
     * Max size value for a user username.
     */
    public static final int USER_USERNAME_MAX_SIZE = 100;

    /**
     * Min size value for a user password.
     */
    public static final int USER_PASSWORD_MIN_SIZE = 8;

    /**
     * Tolerance days limit for refund.
     */
    public static final int REFUND_LIMIT_DAYS = 10;

    /**
     * Default users roles.
     */
    public static final UserRole DEFAULT_ROLES[] = {UserRole.USER};

}
