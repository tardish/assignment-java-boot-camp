package com.example.java_shop_api.payment;

public class PaymentNotFoundException  extends RuntimeException {
    public PaymentNotFoundException(Integer paymentId) {
        super(String.valueOf(paymentId));
    }
}
