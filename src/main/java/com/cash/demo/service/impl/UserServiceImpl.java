package com.cash.demo.service.impl;

import com.cash.demo.entity.User;
import com.cash.demo.repository.LoanRepository;
import com.cash.demo.repository.UserRepository;
import com.cash.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        logger.warn("Search all users from the database");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        logger.warn("Search user {} from database", userId);
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            logger.error("userId {} not exists in database!", userId);
            throw new EntityNotFoundException("userId not found");
        }
        return user;
    }

    @Override
    public User saveUser(User newUser) {
        logger.warn("Save new user {} in database", newUser);
        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(User updateUser, Long userId) {
        logger.info("Search user in database");
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            logger.info("User exists. Set loans from updated user");
            updateUser.setId(userId);
            updateUser.setLoans(user.get().getLoans());
            return saveUser(updateUser);
        }
        logger.info("User not exists. Saving user");
        return saveUser(updateUser);
    }

    @Override
    public void deleteUserById(Long userId) {
        logger.warn("Delete user {} from database", userId);
        userRepository.deleteById(userId);
    }
}
