package com.example.java_shop_api.product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String name) {
        super(name);
    }
    public ProductNotFoundException(Integer id) {
        super(String.valueOf(id));
    }
}
