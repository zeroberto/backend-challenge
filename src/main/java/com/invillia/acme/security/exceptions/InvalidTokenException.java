package com.invillia.acme.security.exceptions;

import com.invillia.acme.core.exceptions.ApplicationException;

/**
 * Exception class for API access token-related errors.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class InvalidTokenException extends ApplicationException {

    public InvalidTokenException() {
    }

    public InvalidTokenException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "exception.security.token.expired_or_invalid";
    }

}
