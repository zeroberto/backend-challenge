package com.invillia.acme.entity;

import com.invillia.acme.core.model.ModelEntity;
import com.invillia.acme.enums.UserRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import static com.invillia.acme.constants.BusinessRulesConstants.*;

/**
 * Entity that represents the user in the model.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "user")
public class User extends ModelEntity {

    @NotNull(message = "{entity.user.validation.username.not_null}")
    @Size(min = DEFAULT_STRING_MIN_SIZE, max = USER_USERNAME_MAX_SIZE, message = "{entity.user.validation.username.out_of_range}")
    private String username;

    @NotNull(message = "{entity.user.validation.password.not_null}")
    @Size(min = USER_PASSWORD_MIN_SIZE, max = DEFAULT_STRING_MAX_SIZE, message = "{entity.user.validation.password.out_of_range}")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<UserRole> roles = new HashSet<>();

}