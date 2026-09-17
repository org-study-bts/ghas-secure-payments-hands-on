package com.example.securepayments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeqlCorrectionTests {
    @Test
    void paymentDescriptionIsHandledAsDataNotAsAnInstruction() {
        PaymentService service = new PaymentService();
        Payment payment = service.create(new CreatePaymentRequest(
                java.math.BigDecimal.ONE, "BRL", "literal; echo NOT_EXECUTED"));
        assertEquals("literal; echo NOT_EXECUTED", payment.description());
    }
}
