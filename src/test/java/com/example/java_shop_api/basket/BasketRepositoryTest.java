package com.example.java_shop_api.basket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BasketRepositoryTest {

    @Autowired
    BasketRepository basketRepository;

    @Test
    void findByUserGuid_with_success() {

        Basket basket = new Basket();
        basket.setProductId(1);
        basket.setProductPrice(555.55);
        basket.setUserGuid("userGuid");
        basketRepository.save(basket);

        List<Basket> result = basketRepository.findByUserGuid("userGuid");
        assertTrue(result.contains(basket));
    }

    @Test
    void findByUserGuid_with_failure() {

        Basket basket = new Basket();
        List<Basket> result = basketRepository.findByUserGuid("userGuid");
        assertFalse(result.contains(basket));
    }
}