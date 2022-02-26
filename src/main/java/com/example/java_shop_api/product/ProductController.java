package com.example.java_shop_api.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private  ProductService productService;

    @GetMapping("api/product/find_product_by_name/{name}")
    public Optional<Product> findProductByName(@PathVariable String name){
        Optional<Product> result = productService.findProductByName(name);
        if(result.isPresent()){
            return  result;
        }
        throw new ProductNotFoundException(name);
    }

    @GetMapping("api/product/get_product_detail/{id}")
    public Optional<Product> findProductByName(@PathVariable Integer id){
        Optional<Product> result = productService.findProductById(id);
        if(result.isPresent()){
            return  result;
        }
        throw new ProductNotFoundException(id);
    }
}
