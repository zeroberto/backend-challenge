package com.invillia.acme.http.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.invillia.acme.core.control.BasicApiRestController;
import com.invillia.acme.dto.OrderDTO;
import com.invillia.acme.dto.PaymentDTO;
import com.invillia.acme.http.AsyncRequestExecutor;
import com.invillia.acme.http.gateway.OrderGateway;
import com.invillia.acme.http.json.DefaultJsonView;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.invillia.acme.constants.PathsConstants.*;
import static com.invillia.acme.http.json.DefaultJsonView.RequestJsonView;

/**
 * Order api controller class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@RestController
@RequestMapping(ORDER_PATH)
public class OrderApiRestController extends BasicApiRestController<OrderDTO, OrderGateway> {

    @PostMapping(ORDER_PAY_PATH)
    @ApiOperation("${controller.order.api.api.method_description}")
    public @JsonView({DefaultJsonView.ResponseJsonView.class}) OrderDTO pay(@NotNull @PathVariable("id") Long id, @JsonView(RequestJsonView.class) @Valid @NotNull @RequestBody PaymentDTO requestDTO) {
        return ((AsyncRequestExecutor<OrderDTO>) () -> getServiceGateway().pay(id, requestDTO).get()).execute(getMessageSource());
    }

    @PostMapping(ORDER_REFUND_PATH)
    @ApiOperation("${controller.order.api.refund.method_description}")
    public @JsonView({DefaultJsonView.ResponseJsonView.class}) OrderDTO refund(@NotNull @PathVariable("id") Long id) {
        return ((AsyncRequestExecutor<OrderDTO>) () -> getServiceGateway().refund(id).get()).execute(getMessageSource());
    }

}