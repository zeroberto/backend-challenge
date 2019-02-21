package com.invillia.acme.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.invillia.acme.enums.OrderStatus;
import com.invillia.acme.http.json.DefaultJsonView;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.invillia.acme.http.json.DefaultJsonView.*;
import static com.invillia.acme.validation.DefaultValidationGroup.*;

/**
 * DTO for requests related to the Order model.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonView({ResponseJsonView.class})
public class OrderDTO {

    private Long id;

    @NotNull(groups = {CreateValidationGroup.class, UpdateValidationGroup.class}, message = "{entity.order.validation.address.not_null}")
    @JsonView(DefaultJsonView.class)
    private String address;

    private LocalDateTime localDateTime;

    private OrderStatus orderStatus;

    @NotNull(groups = {OrderItemsRequiredValidationGroup.class}, message = "{entity.order.validation.order_items.not_null}")
    @NotEmpty(groups = {OrderItemsRequiredValidationGroup.class}, message = "{entity.order.validation.order_items.not_empty}")
    @JsonView({RequestJsonView.class, ResponseJsonView.class, PatchRequestJsonView.class, PutRequestJsonView.class})
    private List<OrderItemDTO> orderItems = new ArrayList<>();

    @NotNull(groups = {PaymentRequiredValidationGroup.class}, message = "{entity.order.validation.payment.not_null}")
    @JsonView({RequestJsonView.class, ResponseJsonView.class, PatchRequestJsonView.class, PutRequestJsonView.class})
    private PaymentDTO payment;

}