package com.invillia.acme.exceptions;

import com.invillia.acme.core.exceptions.ApplicationException;

/**
 * Exception class responsible for reporting failure to using an invalid identifier.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class InvalidIdentifierException extends ApplicationException {

    public InvalidIdentifierException() {
    }

    public InvalidIdentifierException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "exception.model.entity.default.invalid_id";
    }
}
