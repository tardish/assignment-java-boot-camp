package com.example.java_shop_api.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String name) {
        super(name);
    }
}
