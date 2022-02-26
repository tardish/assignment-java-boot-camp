package com.example.java_shop_api.basket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    BasketRepository basketRepository;

    @Test
    @DisplayName("Find Basket By UserGuid With Success")
    void findBasketByUserGuid() {

        ArrayList<Basket> basketList = new ArrayList<Basket>();
        Basket basket = new Basket();
        basket.setProductId(1);
        basket.setProductPrice(555.55);
        basket.setUserGuid("userGuid");
        basketList.add(basket);

        when(basketRepository.findByUserGuid("userGuid")).thenReturn(basketList);
        BasketService basketService = new BasketService();
        basketService.setBasketRepository(basketRepository);
        List<Basket> result = basketService.findBasketByUserGuid("userGuid");
        assertEquals(basketList,result);

    }

    @Test
    @DisplayName("Add Product To Basket With Success")
    void addProductToBasket() {

        Basket basket = new Basket();
        basket.setProductId(1);
        basket.setProductPrice(555.55);
        basket.setUserGuid("userGuid");

        when(basketRepository.save(basket)).thenReturn(basket);

        BasketService basketService = new BasketService();
        basketService.setBasketRepository(basketRepository);
        Basket result = basketService.addProductToBasket(basket);

        assertEquals(basket,result);
    }
}