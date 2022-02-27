package com.example.java_shop_api.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findProductByName() {

        Product product = new Product();
        product.setId(1);
        product.setName("TestProduct");
        product.setPrice(555.55);
        product.setUrlImg("wwe.Images.command");
        productRepository.save(product);
        Optional<Product> result = productRepository.findByName("TestProduct");
        assertTrue(result.isPresent());
    }

    @Test
    void findProductById() {
        Product product = new Product();
        product.setId(1);
        product.setName("TestProduct");
        product.setPrice(555.55);
        product.setUrlImg("wwe.Images.command");
        productRepository.save(product);
        Optional<Product> result = productRepository.findProductById(1);
        assertTrue(result.isPresent());
    }
}