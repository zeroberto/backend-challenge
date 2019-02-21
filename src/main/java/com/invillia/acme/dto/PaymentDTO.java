package com.invillia.acme.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.invillia.acme.http.json.DefaultJsonView;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static com.invillia.acme.constants.BusinessRulesConstants.PAYMENT_CARD_NUMBER_PATTERN;
import static com.invillia.acme.constants.BusinessRulesConstants.PAYMENT_CARD_NUMBER_SIZE;
import static com.invillia.acme.http.json.DefaultJsonView.ResponseJsonView;
import static com.invillia.acme.http.json.DefaultJsonView.SubtypeResponseJsonView;
import static com.invillia.acme.validation.DefaultValidationGroup.CreateValidationGroup;
import static com.invillia.acme.validation.DefaultValidationGroup.UpdateValidationGroup;

/**
 * DTO for requests related to the Payment model.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonView({ResponseJsonView.class})
public class PaymentDTO {

    private Long id;

    @JsonView(DefaultJsonView.class)
    private String description;

    @NotNull(groups = {CreateValidationGroup.class, UpdateValidationGroup.class}, message = "{entity.payment.validation.card_number.not_null}")
    @Size(min = PAYMENT_CARD_NUMBER_SIZE, max = PAYMENT_CARD_NUMBER_SIZE, message = "{entity.payment.validation.card_number.out_of_range}")
    @Pattern(regexp = PAYMENT_CARD_NUMBER_PATTERN, message = "{entity.payment.validation.card_number.invalid}")
    @JsonView(DefaultJsonView.class)
    private String cardNumber;

    private LocalDateTime paymentDate;

    @JsonView(SubtypeResponseJsonView.class)
    private OrderDTO order;

}