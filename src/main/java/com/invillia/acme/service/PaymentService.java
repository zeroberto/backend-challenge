package com.invillia.acme.service;

import com.invillia.acme.core.model.ModelService;
import com.invillia.acme.entity.Payment;
import com.invillia.acme.repository.PaymentRepository;
import org.springframework.stereotype.Service;

/**
 * Payment service class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Service
public class PaymentService extends ModelService<Payment, PaymentRepository> {

    public PaymentService() {
        super(Payment.class);
    }

}