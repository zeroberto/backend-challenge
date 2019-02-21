package com.invillia.acme.repository;

import com.invillia.acme.entity.Payment;
import com.invillia.acme.test.data.factory.OrderTestDataFactory;
import com.invillia.acme.test.data.factory.PaymentTestDataFactory;
import com.invillia.acme.test.suport.ModelRepositoryIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Payment repository integration test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class PaymentRepositoryTest extends ModelRepositoryIntegrationTest<Payment, PaymentRepository> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Payment createModelEntity() {
        Payment payment = new PaymentTestDataFactory().createNew();
        // Save an order
        payment.setOrder(orderRepository.save(new OrderTestDataFactory().createNew()));
        return payment;
    }

}
