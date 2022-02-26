package com.example.java_shop_api.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
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

        when(userRepository.findByUserGuid("test")).thenReturn(Optional.of(user));
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        Optional<User> result = userService.findByUserGuid("test");
        assertTrue(result.isPresent());
    }
}