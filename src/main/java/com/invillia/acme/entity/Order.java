package com.invillia.acme.entity;

import com.invillia.acme.converter.jpa.OrderStatusAttributeConverter;
import com.invillia.acme.core.model.ModelEntity;
import com.invillia.acme.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.invillia.acme.constants.BusinessRulesConstants.*;
import static com.invillia.acme.validation.DefaultValidationGroup.*;

/**
 * Entity that represents the order in the model.
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
@Table(name = "\"order\"")
public class Order extends ModelEntity {

    @NotNull(message = "{entity.order.validation.address.not_null}")
    @Size(min = DEFAULT_STRING_MIN_SIZE, max = DEFAULT_STRING_MAX_SIZE, message = "{entity.order.validation.address.out_of_range}")
    private String address;

    @NotNull(message = "{entity.order.validation.confirmation_date.not_null}")
    private LocalDateTime confirmationDate;

    @NotNull(message = "{entity.order.validation.status.not_null}")
    @Convert(converter = OrderStatusAttributeConverter.class)
    private OrderStatus status;

    @NotNull(groups = {OrderItemsRequiredValidationGroup.class}, message = "{entity.order.validation.order_items.not_null}")
    @NotEmpty(groups = {OrderItemsRequiredValidationGroup.class}, message = "{entity.order.validation.order_items.not_empty}")
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @NotNull(groups = {PaymentRequiredValidationGroup.class}, message = "{entity.order.validation.payment.not_null}")
    @OneToOne(mappedBy = "order")
    private Payment payment;

}