package com.example.java_shop_api.payment;

import com.example.java_shop_api.product.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentControllerAdvice {
    @ExceptionHandler(PaymentNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String paymentNotFound(PaymentNotFoundException e){
        return "Payment id: "+e.getMessage()+" not found";
    }
}
