package com.example.java_shop_api.basket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasketController {

    @Autowired
    BasketService basketService;

    @PostMapping("/api/basket/add")
    public Basket addProductToBasket(Basket basket){
        Basket result = basketService.addProductToBasket(basket);
        return result;
    }

    @GetMapping("/api/basket/{userGuid}")
    public List<Basket> findBasketByUserId(@PathVariable String userGuid){
        List<Basket> result = basketService.findBasketByUserGuid(userGuid);
        if(result.isEmpty()){
            throw new BasketNotFoundException(userGuid);
        }
        return result;
    }

}
