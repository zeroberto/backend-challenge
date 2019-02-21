package com.invillia.acme.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.invillia.acme.enums.UserRole;
import com.invillia.acme.validation.DefaultValidationGroup;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import static com.invillia.acme.constants.BusinessRulesConstants.*;
import static com.invillia.acme.http.json.DefaultJsonView.*;

/**
 * DTO for requests related to the User model.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonView({ResponseJsonView.class})
public class UserDTO {

    private Long id;

    @NotNull(message = "{entity.user.validation.username.not_null}", groups = {DefaultValidationGroup.RequestValidationGroup.class})
    @Size(min = DEFAULT_STRING_MIN_SIZE, max = USER_USERNAME_MAX_SIZE, message = "{entity.user.validation.username.out_of_range}", groups = {DefaultValidationGroup.RequestValidationGroup.class})
    @JsonView({RequestJsonView.class, PatchRequestJsonView.class, ResponseJsonView.class})
    private String username;

    @NotNull(message = "{entity.user.validation.password.not_null}", groups = {DefaultValidationGroup.RequestValidationGroup.class})
    @Size(min = USER_PASSWORD_MIN_SIZE, max = DEFAULT_STRING_MAX_SIZE, message = "{entity.user.validation.password.out_of_range}", groups = {DefaultValidationGroup.RequestValidationGroup.class})
    @JsonView({RequestJsonView.class})
    private String password;

    private Set<UserRole> roles = new HashSet<>();

}