package com.cash.demo.controller;

import com.cash.demo.entity.User;
import com.cash.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> allUsers() {
        logger.info("Get all users");
        return userService.findAllUsers();
    }

    @GetMapping(value = "/users/{userId}")
    public Optional<User> getUser(@PathVariable Long userId) {
        logger.info("Get user {}", userId);
        return userService.findUserById(userId);
    }

    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User newUser) {
        logger.info("Add user {}", newUser);
        return userService.saveUser(newUser);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@Valid @RequestBody User newUser, @PathVariable Long userId) {
        logger.info("Update parameters {} from userId: {}", newUser, userId);
        return userService.updateUser(newUser, userId);
    }

    @DeleteMapping("/users/{userId}")
    void deleteUser(@PathVariable Long userId) {
        logger.info("Delete user {}", userId);
        userService.deleteUserById(userId);
    }

}
