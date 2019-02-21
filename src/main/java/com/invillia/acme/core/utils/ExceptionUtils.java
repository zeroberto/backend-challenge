package com.invillia.acme.core.utils;

/**
 * Class with utilitarian methods to aid in the handling and use of exceptions.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class ExceptionUtils {

    /**
     * Method to throw an exception if the condition is not respected.
     *
     * @param condition Condition to be checked.
     * @param ex        Exception to be thrown if the condition is disregarded.
     */
    public static void orElseThrows(boolean condition, RuntimeException ex) {
        if (condition) {
            throw ex;
        }
    }

}
