package com.invillia.acme.entity;

import com.invillia.acme.test.suport.ModelEntityTest;
import com.invillia.acme.test.data.factory.PaymentTestDataFactory;

/**
 * Payment entity unit test class.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class PaymentTest extends ModelEntityTest<Payment> {

    public PaymentTest() {
        super(new PaymentTestDataFactory());
    }

}
