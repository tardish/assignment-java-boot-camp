package com.example.java_shop_api.payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {


    @Mock
    PaymentRepository paymentRepository;

    @Test
    void createdPayment() {

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

        UserPayment userPayment = new UserPayment();
        userPayment.setUserGuid("test");
        userPayment.setUserName("Sek");
        userPayment.setAmount(555.55);

        when(paymentRepository.save(any())).thenReturn(payment);
        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentRepository(paymentRepository);
        Payment result = paymentService.createdPayment(userPayment);

        assertEquals(payment,result);
    }

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
        when(paymentRepository.findPaymentById(1)).thenReturn(Optional.of(payment));
        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentRepository(paymentRepository);
        Optional<Payment> result = paymentService.findPaymentById(1);
        assertTrue(result.isPresent());
    }
}