package com.example.java_shop_api.basket;

public class BasketNotFoundException extends RuntimeException {
    public BasketNotFoundException(String UserGuid) {
        super(UserGuid);
    }
}
