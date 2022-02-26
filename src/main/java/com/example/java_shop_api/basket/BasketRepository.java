package com.example.java_shop_api.basket;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket,Integer> {

    List<Basket> findByUserGuid(String userGuid);

}
