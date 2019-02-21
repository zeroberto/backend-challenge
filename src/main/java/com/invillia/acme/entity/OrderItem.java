package com.invillia.acme.entity;

import com.invillia.acme.core.model.ModelEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static com.invillia.acme.constants.BusinessRulesConstants.ORDER_ITEM_QUANTITY_MIN;
import static com.invillia.acme.constants.BusinessRulesConstants.ORDER_ITEM_UNIT_PRICE_MIN;
import static com.invillia.acme.validation.DefaultValidationGroup.SupertypeRequiredValidationGroup;

/**
 * Entity that represents the order item in the model.
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
@Table(name = "order_item")
public class OrderItem extends ModelEntity {

    private String description;

    @NotNull(message = "{entity.orderitem.validation.quantity.not_null}")
    @Min(value = ORDER_ITEM_QUANTITY_MIN, message = "{entity.orderitem.validation.quantity.greater_than_zero}")
    private BigDecimal quantity;

    @NotNull(message = "{entity.orderitem.validation.unit_price.not_null}")
    @Min(value = ORDER_ITEM_UNIT_PRICE_MIN, message = "{entity.orderitem.validation.unit_price.not_negative}")
    private BigDecimal unitPrice;

    @NotNull(groups = {SupertypeRequiredValidationGroup.class}, message = "{entity.orderitem.validation.order.not_null}")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}