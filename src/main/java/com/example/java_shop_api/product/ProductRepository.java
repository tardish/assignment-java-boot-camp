package com.example.java_shop_api.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {

     Optional<Product> findByName(String name);
     Optional<Product> findProductById(Integer id);

}
