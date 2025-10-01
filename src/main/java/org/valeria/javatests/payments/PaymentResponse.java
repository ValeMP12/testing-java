package org.valeria.javatests.payments;

public class PaymentResponse {
    enum PaymentSatus {
        OK, ERROR
    }
    private PaymentSatus status;

    public PaymentResponse(PaymentSatus status) {
        this.status = status;
    }

    public PaymentSatus getStatus() {
        return status;
    }
}
