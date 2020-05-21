package com.cash.demo.service;

import com.cash.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();

    Optional<User> findUserById(Long userId);

    User saveUser(User newUser);

    User updateUser(User updateUser, Long userId);

    void deleteUserById(Long userId);

}
