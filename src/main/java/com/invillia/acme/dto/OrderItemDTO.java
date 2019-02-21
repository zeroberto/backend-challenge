package com.invillia.acme.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static com.invillia.acme.constants.BusinessRulesConstants.ORDER_ITEM_QUANTITY_MIN;
import static com.invillia.acme.constants.BusinessRulesConstants.ORDER_ITEM_UNIT_PRICE_MIN;
import static com.invillia.acme.http.json.DefaultJsonView.*;
import static com.invillia.acme.validation.DefaultValidationGroup.CreateValidationGroup;
import static com.invillia.acme.validation.DefaultValidationGroup.UpdateValidationGroup;

/**
 * DTO for requests related to the OrderItem model.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonView({ResponseJsonView.class})
public class OrderItemDTO {

    private Long id;

    private String description;

    @NotNull(groups = {CreateValidationGroup.class, UpdateValidationGroup.class}, message = "{entity.orderitem.validation.quantity.not_null}")
    @Min(groups = {CreateValidationGroup.class, UpdateValidationGroup.class}, value = ORDER_ITEM_QUANTITY_MIN, message = "{entity.orderitem.validation.quantity.greater_than_zero}")
    @JsonView({RequestJsonView.class, ResponseJsonView.class, PatchRequestJsonView.class, PutRequestJsonView.class})
    private BigDecimal quantity;

    @NotNull(groups = {CreateValidationGroup.class, UpdateValidationGroup.class}, message = "{entity.orderitem.validation.unit_price.not_null}")
    @Min(groups = {CreateValidationGroup.class, UpdateValidationGroup.class}, value = ORDER_ITEM_UNIT_PRICE_MIN, message = "{entity.orderitem.validation.unit_price.not_negative}")
    @JsonView({RequestJsonView.class, ResponseJsonView.class, PatchRequestJsonView.class, PutRequestJsonView.class})
    private BigDecimal unitPrice;

    @JsonView({SubtypeResponseJsonView.class})
    private OrderDTO order;

}