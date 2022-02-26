package com.example.java_shop_api.basket;


import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public void setBasketRepository(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public List<Basket> findBasketByUserGuid(String userGuid){
        List<Basket> result = basketRepository.findByUserGuid(userGuid);
        return result;
    }

    public Basket addProductToBasket(@NotNull Basket basket){
        Basket result = basketRepository.save(basket);
        return result;
    }


}
