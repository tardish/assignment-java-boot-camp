package com.example.java_shop_api;

import com.example.java_shop_api.basket.Basket;
import com.example.java_shop_api.basket.BasketRepository;
import com.example.java_shop_api.payment.Payment;
import com.example.java_shop_api.payment.PaymentRepository;
import com.example.java_shop_api.product.Product;
import com.example.java_shop_api.product.ProductRepository;
import com.example.java_shop_api.user.User;
import com.example.java_shop_api.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class JavaShopApiApplication {


	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BasketRepository basketRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PaymentRepository paymentRepository;


	public static void main(String[] args) {
		SpringApplication.run(JavaShopApiApplication.class, args);
	}

}
