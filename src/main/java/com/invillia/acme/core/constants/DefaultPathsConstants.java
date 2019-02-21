package com.invillia.acme.core.constants;

/**
 * Class that contains the default paths for the basic HTTP methods.
 *
 * @author José Roberto <jose.junior@conductor.com.br>
 */
public final class DefaultPathsConstants {

    /**
     * Path separator for URLs.
     */
    public static final String PATH_SEPARATOR = "/";

    /**
     * Path of everything from something
     */
    public static final String PATH_EVERYTHING = PATH_SEPARATOR + "**";

    /**
     * Constant with the default get path.
     */
    public static final String DEFAULT_GET_ONE_PATH = PATH_SEPARATOR + "{id}";

    /**
     * Constant with the default put path.
     */
    public static final String DEFAULT_PUT_PATH = DEFAULT_GET_ONE_PATH;

    /**
     * Constant with the default delete path.
     */
    public static final String DEFAULT_DELETE_PATH = DEFAULT_GET_ONE_PATH;

    /**
     * Constant with the default patch path.
     */
    public static final String DEFAULT_PATCH_PATH = DEFAULT_GET_ONE_PATH;

}
