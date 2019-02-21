package com.invillia.acme.core.control;

import com.fasterxml.jackson.annotation.JsonView;
import com.invillia.acme.core.gateway.ServiceGateway;
import com.invillia.acme.core.utils.SimpleEntry;
import com.invillia.acme.http.AsyncRequestExecutor;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.invillia.acme.core.constants.DefaultPathsConstants.*;
import static com.invillia.acme.core.utils.HeadersUtils.getLocationHeader;
import static com.invillia.acme.http.json.DefaultJsonView.*;
import static com.invillia.acme.validation.DefaultValidationGroup.*;

/**
 * Base class for rest controllers containing methods common to most HTTP controllers.
 * <p>
 * This class seeks to decrease effort and repeatability for creating controllers for entities.
 *
 * @author José Roberto <jose.junior@conductor.com.br>
 */
public abstract class BasicApiRestController<DTO, SG extends ServiceGateway<DTO, ?, ?, ?>> extends ApiRestController<SG> {

    @GetMapping
    @ApiOperation("${controller.default.api.get.method_description}")
    public @JsonView({ResponseJsonView.class})
    List<DTO> get() {
        return ((AsyncRequestExecutor<List<DTO>>) () -> getServiceGateway().list().get()).execute(getMessageSource());
    }

    @GetMapping(DEFAULT_GET_ONE_PATH)
    @ApiOperation("${controller.default.api.get_one.method_description}")
    public @JsonView({ResponseJsonView.class})
    DTO getOne(@NotNull @PathVariable("id") Long id) {
        return ((AsyncRequestExecutor<DTO>) () -> getServiceGateway().find(id).get()).execute(getMessageSource());
    }

    @PostMapping
    @ApiOperation("${controller.default.api.post.method_description}")
    public @JsonView({ResponseJsonView.class})
    DTO post(@NotNull @JsonView({RequestJsonView.class}) @Validated({CreateValidationGroup.class}) @RequestBody DTO requestDTO) {
        return ((AsyncRequestExecutor<DTO>) () -> getServiceGateway().create(requestDTO).get()).execute(getMessageSource());
    }

    @PutMapping(DEFAULT_PUT_PATH)
    @ApiOperation("${controller.default.api.put.method_description}")
    public @JsonView({ResponseJsonView.class})
    ResponseEntity<DTO> put(@NotNull @PathVariable("id") Long id, @JsonView(PutRequestJsonView.class) @Validated({UpdateValidationGroup.class}) @NotNull @RequestBody DTO requestDTO, HttpServletRequest request) {
        SimpleEntry<DTO, HttpStatus> simpleEntry = ((AsyncRequestExecutor<SimpleEntry<DTO, HttpStatus>>) () ->
                getServiceGateway().update(id, requestDTO).get()
        ).execute(getMessageSource());
        return new ResponseEntity<>(simpleEntry.getKey(), getLocationHeader(new HttpHeaders(), request, id), simpleEntry.getValue());
    }

    @DeleteMapping(DEFAULT_DELETE_PATH)
    @ApiOperation("${controller.default.api.delete.method_description}")
    public @JsonView({ResponseJsonView.class})
    DTO delete(@NotNull @PathVariable("id") Long id) {
        return ((AsyncRequestExecutor<DTO>) () -> getServiceGateway().delete(id).get()).execute(getMessageSource());
    }

    @PatchMapping(DEFAULT_PATCH_PATH)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("${controller.default.api.patch.method_description}")
    public void patch(@NotNull @PathVariable("id") Long id, @JsonView(PatchRequestJsonView.class) @Validated({PartialUpdateValidationGroup.class}) @NotNull @RequestBody DTO requestDTO) {
        ((AsyncRequestExecutor<DTO>) () -> getServiceGateway().delete(id).get()).execute(getMessageSource());
    }

}
