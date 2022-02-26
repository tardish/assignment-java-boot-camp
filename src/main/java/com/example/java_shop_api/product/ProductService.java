package com.example.java_shop_api.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    public Optional<Product> findProductByName(String name){
        Optional<Product> result = productRepository.findByName(name);
        return  result;
    }

    public Optional<Product> findProductById(Integer id){
        Optional<Product> result = productRepository.findProductById(id);
        return  result;
    }
}
