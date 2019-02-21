package com.invillia.acme.test.data.factory;

import com.invillia.acme.entity.Payment;

import java.time.LocalDateTime;

/**
 * Payment test data factory class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class PaymentTestDataFactory implements TestDataFactory<Payment> {

    public static final Long VALID_ID = 1L;
    public static final String VALID_CARD_NUMBER = "1234567890123456";
    public static final String VALID_DESCRIPTION = "Lorem ipsum dolor sit amet";
    public static final LocalDateTime VALID_PAYMENT_DATE = LocalDateTime.now();

    public static final Long INVALID_ID = -1L;
    public static final String INVALID_CARD_NUMBER_WITH_LETTERS = "12345678901234ab";
    public static final String INVALID_CARD_NUMBER_LESS_THAN_REQUIRED = "123456789012345";
    public static final String INVALID_CARD_NUMBER_GREATER_THAN_REQUIRED = "12345678901234567";

    @Override
    public Payment createNew() {
        Payment payment = new Payment();
        payment.setCardNumber(VALID_CARD_NUMBER);
        payment.setDescription(VALID_DESCRIPTION);
        payment.setPaymentDate(VALID_PAYMENT_DATE);
        return payment;
    }

    @Override
    public Payment create() {
        Payment payment = createNew();
        payment.setId(VALID_ID);
        return payment;
    }

    @Override
    public Payment createNewInvalid() {
        Payment payment = new Payment();
        payment.setCardNumber(INVALID_CARD_NUMBER_WITH_LETTERS);
        payment.setDescription(VALID_DESCRIPTION);
        payment.setPaymentDate(VALID_PAYMENT_DATE);
        return payment;
    }

    @Override
    public Payment createInvalid() {
        Payment payment = createNewInvalid();
        payment.setId(INVALID_ID);
        return payment;
    }

}
