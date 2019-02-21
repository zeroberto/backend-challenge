package com.invillia.acme.exceptions;

import com.invillia.acme.core.exceptions.ApplicationException;

/**
 * Exception class responsible for reporting failure to using an invalid parameter.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class InvalidParameterException extends ApplicationException {

    public InvalidParameterException() {
    }

    public InvalidParameterException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "exception.model.entity.default.invalid_parameter";
    }

}
