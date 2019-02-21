package com.invillia.acme.repository;

import com.invillia.acme.core.model.ModelRepository;
import com.invillia.acme.entity.Order;
import com.invillia.acme.entity.Payment;

import java.util.Optional;

/**
 * Payment entity repository.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public interface PaymentRepository extends ModelRepository<Payment> {

    /**
     * Find payment by order.
     *
     * @param order Desired order.
     * @return Found Payment.
     */
    Optional<Payment> findByOrder(Order order);

}