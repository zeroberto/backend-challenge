package com.invillia.acme.core.control;

import com.invillia.acme.core.gateway.ServiceGateway;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * Generic class with http methods common to most api controllers.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Getter(AccessLevel.PROTECTED)
public abstract class ApiRestController<SG extends ServiceGateway> {

    @Autowired
    private SG serviceGateway;

    @Autowired
    private MessageSource messageSource;

}