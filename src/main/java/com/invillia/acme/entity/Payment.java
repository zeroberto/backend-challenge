package com.invillia.acme.entity;

import com.invillia.acme.core.model.ModelEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static com.invillia.acme.constants.BusinessRulesConstants.PAYMENT_CARD_NUMBER_PATTERN;
import static com.invillia.acme.constants.BusinessRulesConstants.PAYMENT_CARD_NUMBER_SIZE;
import static com.invillia.acme.validation.DefaultValidationGroup.*;

/**
 * Entity that represents the payment in the model.
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
@Table(name = "payment")
public class Payment extends ModelEntity {

    private String description;

    @NotNull(groups = {CreateValidationGroup.class, UpdateValidationGroup.class}, message = "{entity.payment.validation.card_number.not_null}")
    @Size(min = PAYMENT_CARD_NUMBER_SIZE, max = PAYMENT_CARD_NUMBER_SIZE, message = "{entity.payment.validation.card_number.out_of_range}")
    @Pattern(regexp = PAYMENT_CARD_NUMBER_PATTERN, message = "{entity.payment.validation.card_number.invalid}")
    private String cardNumber;

    @NotNull(message = "{entity.payment.validation.payment_date.not_null}")
    private LocalDateTime paymentDate;

    @NotNull(groups = {SupertypeRequiredValidationGroup.class}, message = "{entity.payment.validation.order.not_null}")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}