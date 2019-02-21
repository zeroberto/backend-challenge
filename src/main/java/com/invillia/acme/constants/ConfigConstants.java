package com.invillia.acme.constants;

/**
 * Class containing the constants with the configurations constants.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public final class ConfigConstants {

    /**
     * Constant representing the size of the TaskExecutor pool.
     */
    public static final int ASYNC_CORE_POOL_SIZE = 20;

    /**
     * Constant representing the maximum size of the TaskExecutor pool.
     */
    public static final int ASYNC_MAX_POOL_SIZE = 100;

    /**
     * Constant representing the queue capacity of the TaskExecutor pool.
     */
    public static final int ASYNC_QUEUE_CAPACITY = 500;

    /**
     * Constant representing the prefix of the TaskExecutor.
     */
    public static final String ASYNC_PREFIX = "Async-";

    /**
     * Password encrypt strenght.
     */
    public static final int STRENGTH = 16;

    /**
     * Secret key.
     */
    public static final String SECRET_KEY = "INv1ll1@A42yhraH.1xx";

}
