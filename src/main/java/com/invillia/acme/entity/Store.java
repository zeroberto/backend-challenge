package com.invillia.acme.entity;

import com.invillia.acme.core.model.ModelEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.invillia.acme.constants.BusinessRulesConstants.DEFAULT_STRING_MAX_SIZE;
import static com.invillia.acme.constants.BusinessRulesConstants.DEFAULT_STRING_MIN_SIZE;

/**
 * Entity that represents the store in the model.
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
@Table(name = "store")
public class Store extends ModelEntity {

    @NotNull(message = "{entity.store.validation.name.not_null}")
    @Size(min = DEFAULT_STRING_MIN_SIZE, max = DEFAULT_STRING_MAX_SIZE, message = "{entity.store.validation.name.out_of_range}")
    private String name;

    @NotNull(message = "{entity.store.validation.address.not_null}")
    @Size(min = DEFAULT_STRING_MIN_SIZE, max = DEFAULT_STRING_MAX_SIZE, message = "{entity.store.validation.address.out_of_range}")
    private String address;

}