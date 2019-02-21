package com.invillia.acme.constants;

import static com.invillia.acme.core.constants.DefaultPathsConstants.PATH_SEPARATOR;

/**
 * Class containing the constants with the API paths.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public final class PathsConstants {

    /**
     * Constant with the path to Order related resources.
     */
    public static final String ORDER_PATH = PATH_SEPARATOR + "orders";

    /**
     * Constant with the path to Order Item related resources.
     */
    public static final String ORDER_ITEM_PATH = PATH_SEPARATOR + "orders-items";

    /**
     * Constant with the path to Payment related resources.
     */
    public static final String PAYMENT_PATH = PATH_SEPARATOR + "payments";

    /**
     * Constant with the path to Store related resources.
     */
    public static final String STORE_PATH = PATH_SEPARATOR + "stores";

    /**
     * Constant with the path to Store related resources.
     */
    public static final String STORE_GET_BY_NAME_PATH = PATH_SEPARATOR + "get-by-name" + PATH_SEPARATOR + "{name}";

    /**
     * Constant with the refund order path.
     */
    public static final String ORDER_PAY_PATH = PATH_SEPARATOR + "pay";

    /**
     * Constant with the refund order path.
     */
    public static final String ORDER_REFUND_PATH = PATH_SEPARATOR + "refund";

    /**
     * Constant with the path to User related resources.
     */
    public static final String USER_PATH = PATH_SEPARATOR + "users";

    /**
     * Constant with the user login path.
     */
    public static final String USER_LOGIN_PATH = PATH_SEPARATOR + "login";

    /**
     * Constant with the user sign up path.
     */
    public static final String USER_SIGNUP_PATH = PATH_SEPARATOR + "signup";

    /**
     * Class containing the paths groups.
     */
    public static class Groups {

        /**
         * Constant with the swagger documentation path.
         */
        public static final String[] SWAGGER_PATHS = {
                "/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
                "/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui",
                "/swagger-ui.html"
        };

        /**
         * Constant containing the routes of the critical group of administrators.
         */
        public static final String[] ADMIN_CRITICAL_PATHS = {
                USER_PATH
        };

        /**
         * Constant containing the critical routes group of sellers.
         */
        public static final String[] SELLER_CRITICAL_PATHS = {
                ORDER_PATH, ORDER_ITEM_PATH, PAYMENT_PATH
        };

    }


}
