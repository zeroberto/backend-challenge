package com.invillia.acme.security.exceptions;

import com.invillia.acme.core.exceptions.ApplicationException;

/**
 * Exception class for authentication errors.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class AuthenticationException extends ApplicationException {

    public AuthenticationException() {
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "exception.security.auth.authentication_failure";
    }

}
