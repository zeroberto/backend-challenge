package com.invillia.acme.http;

import com.invillia.acme.core.exceptions.ApplicationException;
import com.invillia.acme.http.exceptions.AsyncRequestException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.Locale;
import java.util.concurrent.ExecutionException;

import static com.invillia.acme.http.utils.ExceptionsStatusMapper.getHttpStatus;

/**
 * Interface to perform actions when executing callbacks to HTTP request methods asynchronously.
 *
 * @param <T> Desired return type.
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public interface AsyncRequestExecutor<T> {

    /**
     * Task that will be executed in the execute method.
     *
     * @return The desired return object.
     * @throws InterruptedException
     * @throws ExecutionException
     */
    T task() throws InterruptedException, ExecutionException;

    /**
     * Method responsible for performing the gateway form task.
     *
     * @param messageSource Messages source.
     * @return The desired return object.
     */
    default T execute(MessageSource messageSource) {
        try {
            return task();
        } catch (Exception e) {
            if (e.getCause() instanceof ApplicationException) {
                throw new AsyncRequestException(
                        getHttpStatus(e.getCause().getClass()),
                        messageSource.getMessage(e.getCause().getMessage(), null, Locale.getDefault()),
                        e.getCause()
                );
            } else {
                throw new AsyncRequestException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
            }
        }
    }

}