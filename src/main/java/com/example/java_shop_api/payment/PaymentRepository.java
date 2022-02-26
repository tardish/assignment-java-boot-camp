package com.example.java_shop_api.payment;

import com.example.java_shop_api.basket.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Optional<Payment> findPaymentById(Integer paymentId);
}
