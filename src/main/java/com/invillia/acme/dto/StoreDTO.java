package com.invillia.acme.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.invillia.acme.http.json.DefaultJsonView;
import com.invillia.acme.validation.DefaultValidationGroup;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.invillia.acme.constants.BusinessRulesConstants.DEFAULT_STRING_MAX_SIZE;
import static com.invillia.acme.constants.BusinessRulesConstants.DEFAULT_STRING_MIN_SIZE;
import static com.invillia.acme.http.json.DefaultJsonView.ResponseJsonView;
import static com.invillia.acme.validation.DefaultValidationGroup.CreateValidationGroup;
import static com.invillia.acme.validation.DefaultValidationGroup.UpdateValidationGroup;

/**
 * DTO for requests related to the Store model.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonView({ResponseJsonView.class})
public class StoreDTO {

    private Long id;

    @NotNull(groups = {CreateValidationGroup.class, UpdateValidationGroup.class}, message = "{entity.store.validation.name.not_null}")
    @Size(groups = DefaultValidationGroup.class, min = DEFAULT_STRING_MIN_SIZE, max = DEFAULT_STRING_MAX_SIZE, message = "{entity.store.validation.name.out_of_range}")
    @JsonView(DefaultJsonView.class)
    private String name;

    @NotNull(groups = DefaultValidationGroup.class, message = "{entity.store.validation.address.not_null}")
    @Size(groups = DefaultValidationGroup.class, min = DEFAULT_STRING_MIN_SIZE, max = DEFAULT_STRING_MAX_SIZE, message = "{entity.store.validation.address.out_of_range}")
    @JsonView(DefaultJsonView.class)
    private String address;

}