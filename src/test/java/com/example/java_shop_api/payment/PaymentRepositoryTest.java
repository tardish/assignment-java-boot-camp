package com.example.java_shop_api.payment;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    void findPaymentById() {

        Payment payment = new Payment();
        payment.setId(1);
        payment.setUserGuid("test");
        payment.setName("Sek");
        payment.setAmount(555.55);
        payment.setInvoiceNo("231564623");
        payment.setBarcode("000874841510");
        payment.setTransactionDate("25/02/2018 23:33");
        payment.setExpiredDate("27/02/2018 23:33");
        payment.setDetail("JavaShop");
        payment.setPayee("www.JavaShop.com \n Tel:0009900");
        paymentRepository.save(payment);

        Optional<Payment> result = paymentRepository.findPaymentById(1);
        assertTrue(result.isPresent());
    }
}