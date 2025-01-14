package com.example.java_shop_api.basket;

import com.example.java_shop_api.product.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BasketControllerAdvice {
    @ExceptionHandler(BasketNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String basketNotFound(BasketNotFoundException e){
        return "Basket : "+e.getMessage()+" not found";
    }
}
