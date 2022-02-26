package com.example.java_shop_api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("api/user/user_info/{userGuid}")
    public Optional<User> findUserInfoByUserGuid(@PathVariable String userGuid){
        Optional<User> result = userService.findByUserGuid(userGuid);
        if (result.isPresent()){
            return  result;
        }
        throw  new UserNotFoundException(userGuid);
    }


}
