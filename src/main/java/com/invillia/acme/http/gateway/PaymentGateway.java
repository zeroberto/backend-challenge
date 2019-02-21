package com.invillia.acme.http.gateway;

import com.invillia.acme.core.gateway.ServiceGateway;
import com.invillia.acme.dto.PaymentDTO;
import com.invillia.acme.entity.Payment;
import com.invillia.acme.repository.PaymentRepository;
import com.invillia.acme.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * Payment service gateway class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Component
public class PaymentGateway extends ServiceGateway<PaymentDTO, Payment, PaymentRepository, PaymentService> {

    public PaymentGateway() {
        super(PaymentDTO.class);
    }

}
