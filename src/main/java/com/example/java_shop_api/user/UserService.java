package com.example.java_shop_api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public Optional<User> findByUserGuid(String userGuid){
        Optional<User> result = userRepository.findByUserGuid(userGuid);
        return  result;
    }


}
