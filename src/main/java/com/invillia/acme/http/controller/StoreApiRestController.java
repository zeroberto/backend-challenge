package com.invillia.acme.http.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.invillia.acme.core.control.BasicApiRestController;
import com.invillia.acme.dto.StoreDTO;
import com.invillia.acme.http.AsyncRequestExecutor;
import com.invillia.acme.http.gateway.StoreGateway;
import com.invillia.acme.http.json.DefaultJsonView;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import static com.invillia.acme.constants.PathsConstants.STORE_GET_BY_NAME_PATH;
import static com.invillia.acme.constants.PathsConstants.STORE_PATH;

/**
 * Store api controller class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@RestController
@RequestMapping(STORE_PATH)
public class StoreApiRestController extends BasicApiRestController<StoreDTO, StoreGateway> {

    @GetMapping(STORE_GET_BY_NAME_PATH)
    @ApiOperation("${controller.store.api.get_one_by_name.method_description}")
    public @JsonView({DefaultJsonView.ResponseJsonView.class}) StoreDTO getOneByName(@NotNull @PathVariable("name") String name) {
        return ((AsyncRequestExecutor<StoreDTO>) () -> getServiceGateway().findByName(name).get()).execute(getMessageSource());
    }

}