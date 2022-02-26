package com.example.java_shop_api.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/api/payment/created_payment")
    public Payment checkOut(UserPayment userPayment){
        Payment payment = paymentService.createdPayment(userPayment);
        return  payment;
    }

    @GetMapping("/api/payment/find_by_id/{paymentId}")
    public Optional<Payment> findPaymentById(@PathVariable Integer paymentId){
        Optional<Payment>  payment = paymentService.findPaymentById(paymentId);
        if(payment.isPresent()){
            return payment;
        }
        throw new PaymentNotFoundException(paymentId);
    }

}
