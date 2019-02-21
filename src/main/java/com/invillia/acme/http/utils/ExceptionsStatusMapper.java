package com.invillia.acme.http.utils;

import com.invillia.acme.exceptions.InvalidIdentifierException;
import com.invillia.acme.exceptions.InvalidParameterException;
import com.invillia.acme.exceptions.ModelEntityNotFoundException;
import com.invillia.acme.exceptions.UsernameAlreadyExistsException;
import com.invillia.acme.security.exceptions.AuthenticationException;
import com.invillia.acme.security.exceptions.InvalidTokenException;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Map of exceptions and http errors.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class ExceptionsStatusMapper {

    public static final Map<Class<?>, HttpStatus> EXCEPTIONS_STATUS_MAP = fill();

    /**
     * Obtain the HTTP code related to the exception.
     *
     * @param desiredClass Desired exception class.
     * @return The HTTP status code.
     */
    public static HttpStatus getHttpStatus(Class<?> desiredClass) {
        return EXCEPTIONS_STATUS_MAP.get(desiredClass);
    }

    /**
     * Method responsible for filling out the exceptions map.
     *
     * @return The filled map.
     */
    private static Map<Class<?>, HttpStatus> fill() {
        final Map<Class<?>, HttpStatus> map = new HashMap<>();
        map.put(InvalidIdentifierException.class, HttpStatus.BAD_REQUEST);
        map.put(InvalidParameterException.class, HttpStatus.BAD_REQUEST);
        map.put(ModelEntityNotFoundException.class, HttpStatus.NOT_FOUND);
        map.put(UsernameAlreadyExistsException.class, HttpStatus.BAD_REQUEST);
        map.put(InvalidTokenException.class, HttpStatus.FORBIDDEN);
        map.put(AuthenticationException.class, HttpStatus.FORBIDDEN);
        return map;
    }

}
