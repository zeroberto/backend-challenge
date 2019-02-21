package com.invillia.acme.service;

import com.invillia.acme.core.exceptions.ApplicationException;
import com.invillia.acme.entity.Order;
import com.invillia.acme.entity.Payment;
import com.invillia.acme.enums.OrderStatus;
import com.invillia.acme.repository.OrderRepository;
import com.invillia.acme.test.data.factory.OrderTestDataFactory;
import com.invillia.acme.test.data.factory.PaymentTestDataFactory;
import com.invillia.acme.test.suport.ModelServiceTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static com.invillia.acme.constants.BusinessRulesConstants.REFUND_LIMIT_DAYS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Order service unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class OrderServiceTest extends ModelServiceTest<Order, OrderRepository, OrderService> {

    @InjectMocks
    private OrderService service;

    @Mock
    private OrderRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Override
    protected Order createEntity() {
        return new OrderTestDataFactory().create();
    }

    @Override
    protected OrderRepository getRepository() {
        return this.repository;
    }

    @Override
    protected OrderService getService() {
        return this.service;
    }

    @Test
    void givenAnOrder_whenPay_thenSuccess() {
        Payment payment = new PaymentTestDataFactory().createNew();
        Order order = new OrderTestDataFactory().create();
        when(getRepository().findById(Mockito.anyLong())).thenReturn(Optional.of(order));
        when(getRepository().existsById(Mockito.anyLong())).thenReturn(true);
        getService().pay(order.getId(), payment);
        assertAll("validate payment",
                () -> assertEquals(order.getPayment(), payment),
                () -> assertEquals(order.getStatus(), OrderStatus.FINALIZED));
    }

    @Test
    void givenAnOrder_whenPaymentHasAlreadyBeenMade_thenFailure() {
        Payment payment = new PaymentTestDataFactory().create();
        Order order = new OrderTestDataFactory().create();
        order.setPayment(payment);
        when(getRepository().findById(Mockito.anyLong())).thenReturn(Optional.of(order));
        assertThrows(ApplicationException.class, () -> getService().pay(order.getId(), payment));
    }

    @Test
    void givenAnOrder_whenRefund_thenSuccess() {
        Order order = new OrderTestDataFactory().create();
        Payment payment = new PaymentTestDataFactory().create();
        order.setPayment(payment);
        when(getRepository().findById(Mockito.anyLong())).thenReturn(Optional.of(order));
        when(getRepository().existsById(Mockito.anyLong())).thenReturn(true);
        getService().refund(order.getId());
        assertEquals(order.getStatus(), OrderStatus.REFUNDED);
    }

    @Test
    void givenAnOrder_whenRefundAndDateHasExpired_thenFailure() {
        Order order = new OrderTestDataFactory().create();
        Payment payment = new PaymentTestDataFactory().create();
        order.setConfirmationDate(LocalDateTime.now().minus(REFUND_LIMIT_DAYS + 1, ChronoUnit.DAYS));
        when(getRepository().findById(Mockito.anyLong())).thenReturn(Optional.of(order));
        assertThrows(ApplicationException.class, () -> getService().pay(order.getId(), payment));
    }

}
