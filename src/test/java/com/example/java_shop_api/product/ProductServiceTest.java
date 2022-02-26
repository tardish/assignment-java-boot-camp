package com.example.java_shop_api.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @Test
    void findByName() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(555.55);
        product.setUrlImg("wwe.Images.command");

        when(productRepository.findByName("TestProduct")).thenReturn(Optional.of(product));
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        Optional<Product> result = productRepository.findByName("TestProduct");
        assertTrue(result.isPresent());
    }

    @Test
    void findProductById() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(555.55);
        product.setUrlImg("wwe.Images.command");

        when(productRepository.findProductById(1)).thenReturn(Optional.of(product));
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        Optional<Product> result = productRepository.findProductById(1);
        assertTrue(result.isPresent());
    }
}