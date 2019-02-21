package com.invillia.acme.exceptions;

import com.invillia.acme.core.exceptions.ApplicationException;

/**
 * Exception class responsible for reporting a failure while trying to save a user
 * with a username already in the database.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class UsernameAlreadyExistsException extends ApplicationException {

    public UsernameAlreadyExistsException() {
    }

    public UsernameAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "exception.model.entity.user.username_already_exists";
    }
}
