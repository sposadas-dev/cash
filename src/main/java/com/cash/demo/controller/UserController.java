package com.cash.demo.controller;

import com.cash.demo.entity.User;
import com.cash.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value = "User Management System")
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "View a list of available users", response = List.class)
    @GetMapping("/users")
    public List<User> allUsers() {
        logger.info("Get all users");
        return userService.findAllUsers();
    }

    @ApiOperation(value = "Get an user by Id", response = User.class)
    @GetMapping(value = "/users/{userId}")
    public Optional<User> getUser(@PathVariable Long userId) {
        logger.info("Get user {}", userId);
        return userService.findUserById(userId);
    }

    @ApiOperation(value = "Add an user")
    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User newUser) {
        logger.info("Add user {}", newUser);
        return userService.saveUser(newUser);
    }

    @ApiOperation(value = "Update an user")
    @PutMapping("/users/{userId}")
    public User updateUser(@Valid @RequestBody User newUser, @PathVariable Long userId) {
        logger.info("Update parameters {} from userId: {}", newUser, userId);
        return userService.updateUser(newUser, userId);
    }

    @ApiOperation(value = "Delete an user")
    @DeleteMapping("/users/{userId}")
    void deleteUser(@PathVariable Long userId) {
        logger.info("Delete user {}", userId);
        userService.deleteUserById(userId);
    }

}
