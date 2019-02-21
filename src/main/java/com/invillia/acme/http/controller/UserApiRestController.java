package com.invillia.acme.http.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.invillia.acme.core.control.BasicApiRestController;
import com.invillia.acme.dto.UserDTO;
import com.invillia.acme.http.AsyncRequestExecutor;
import com.invillia.acme.http.gateway.UserGateway;
import com.invillia.acme.http.json.DefaultJsonView;
import com.invillia.acme.validation.DefaultValidationGroup;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

import static com.invillia.acme.constants.PathsConstants.*;

/**
 * User api controller class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@RestController
@RequestMapping(USER_PATH)
public class UserApiRestController extends BasicApiRestController<UserDTO, UserGateway> {

    @PostMapping(USER_LOGIN_PATH)
    @ApiOperation("${controller.user.api.login.method_description}")
    public String login(@Validated @NotNull @RequestParam("username") String username, @Validated @NotNull @RequestParam("password") String password) {
        return ((AsyncRequestExecutor<String>) () -> getServiceGateway().login(username, password).get()).execute(getMessageSource());
    }

    @PostMapping(USER_SIGNUP_PATH)
    @ApiOperation("${controller.user.api.signup.method_description}")
    public String signup(@Validated({DefaultValidationGroup.CreateValidationGroup.class}) @NotNull @JsonView({DefaultJsonView.RequestJsonView.class}) @RequestBody UserDTO requestDTO) {
        return ((AsyncRequestExecutor<String>) () -> getServiceGateway().signup(requestDTO).get()).execute(getMessageSource());
    }

}