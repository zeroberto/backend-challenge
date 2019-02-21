package com.invillia.acme.exceptions;

import com.invillia.acme.core.exceptions.ApplicationException;
import com.invillia.acme.core.model.ModelEntity;

/**
 * Exception class responsible for reporting failure to search for an entity.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class ModelEntityNotFoundException extends ApplicationException {

    private Class<? extends ModelEntity> type;

    public ModelEntityNotFoundException(Class<? extends ModelEntity> type) {
        this.type = type;
    }

    public ModelEntityNotFoundException(Throwable cause, Class<? extends ModelEntity> type) {
        super(cause);
        this.type = type;
    }

    @Override
    public String getMessage() {
        return "exception.model.entity." + type.getSimpleName().toLowerCase() + ".not_found";
    }
}
