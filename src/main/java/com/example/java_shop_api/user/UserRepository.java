package com.example.java_shop_api.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Integer> {

    Optional<User> findByUserGuid(String userGuid);

}
