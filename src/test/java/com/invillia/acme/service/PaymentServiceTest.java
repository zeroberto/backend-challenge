package com.invillia.acme.service;

import com.invillia.acme.entity.Payment;
import com.invillia.acme.repository.PaymentRepository;
import com.invillia.acme.test.data.factory.PaymentTestDataFactory;
import com.invillia.acme.test.suport.ModelServiceTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Payment service unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class PaymentServiceTest extends ModelServiceTest<Payment, PaymentRepository, PaymentService> {

    @InjectMocks
    private PaymentService service;

    @Mock
    private PaymentRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Override
    protected Payment createEntity() {
        return new PaymentTestDataFactory().create();
    }

    @Override
    protected PaymentRepository getRepository() {
        return this.repository;
    }

    @Override
    protected PaymentService getService() {
        return this.service;
    }

}
