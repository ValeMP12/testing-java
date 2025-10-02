package org.valeria.javatests.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PaymentProcessorTest {
    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setUp() {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);


    }

    @Test
    public void paymentIsCorrect() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
               .thenReturn(new PaymentResponse(PaymentResponse.PaymentSatus.OK));

        assertTrue(paymentProcessor.makePayment(1000));
    }
    @Test
    public void paymentIsWrong() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentSatus.ERROR));

        assertFalse(paymentProcessor.makePayment(1000));
    }



}