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
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	@PostConstruct
	public void initialData(){
		Product product = new Product();
		product.setName("TestProduct");
		product.setPrice(555.55);
		product.setUrlImg("wwe.Images.command");
		productRepository.save(product);

		Basket basket = new Basket();
		basket.setProductId(1);
		basket.setProductPrice(555.55);
		basket.setUserGuid("userGuid");
		basketRepository.save(basket);

		User user = new User();
		user.setUserGuid("test");
		user.setName("Sek");
		user.setPhone("00555500");
		user.setEmail("sek.com");
		user.setDistrict("district");
		user.setSubDistrict("156789");
		user.setAddress("1150");
		user.setAlley("alley");
		user.setRoad("1112");
		user.setTown("phayao");
		userRepository.save(user);

		String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		String invoiceNo = "00"+dateString;
		String barcode = "01"+dateString;
		String transactionDate = dateString;
		String expireDate = dateString;

		Payment payment = new Payment();
		payment.setId(1);
		payment.setUserGuid("test");
		payment.setName("Sek");
		payment.setAmount(555.55);
		payment.setInvoiceNo(invoiceNo);
		payment.setBarcode(barcode);
		payment.setTransactionDate(transactionDate);
		payment.setExpiredDate(expireDate);
		payment.setDetail("JavaShop");
		payment.setPayee("www.JavaShop.com \n Tel:0009900");
		paymentRepository.save(payment);
	}


	public static void main(String[] args) {
		SpringApplication.run(JavaShopApiApplication.class, args);
	}

}
