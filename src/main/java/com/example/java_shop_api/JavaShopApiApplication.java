package com.example.java_shop_api;

import com.example.java_shop_api.product.Product;
import com.example.java_shop_api.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JavaShopApiApplication {


	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public void initialData(){
		Product product = new Product();
		product.setName("TestProduct");
		product.setPrice(555.55);
		product.setUrlImg("wwe.Images.command");
		productRepository.save(product);
	}


	public static void main(String[] args) {
		SpringApplication.run(JavaShopApiApplication.class, args);
	}

}
