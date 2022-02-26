package com.example.java_shop_api.user;

import com.example.java_shop_api.product.Product;
import com.example.java_shop_api.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByUserGuid() {
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

        Optional<User> result = userRepository.findByUserGuid("test");
        assertTrue(result.isPresent());
    }
}