package com.invillia.acme.http.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception responsible for reporting fails in asynchronous method executions.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class AsyncRequestException extends ResponseStatusException {

    public AsyncRequestException(HttpStatus status) {
        super(status);
    }

    public AsyncRequestException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public AsyncRequestException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

}