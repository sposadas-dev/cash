package com.cash.demo;

import com.cash.demo.entity.Loan;
import com.cash.demo.entity.User;
import com.cash.demo.repository.LoanRepository;
import com.cash.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Runner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void run(String... args) {

        logger.info("Initialize database");
        User user1 = userRepository.save(new User("Eduardo", "Pochidis", "pochidis.e@gmail.com"));
        User user2 = userRepository.save(new User("Mariana", "Castaña", "castaña.m@gmail.com"));
        User user3 = userRepository.save(new User("Simon", "Pedro", "pedro.s@gmail.com"));
        User user4 = userRepository.save(new User("Sofia", "Veren", "veren.s@gmail.com"));

        loanRepository.save(new Loan(new BigDecimal("15500.55"), user1.getId()));
        loanRepository.save(new Loan(new BigDecimal("12500"), user1.getId()));

        loanRepository.save(new Loan(new BigDecimal("31000"), user2.getId()));

        loanRepository.save(new Loan(new BigDecimal("21500"), user3.getId()));
        loanRepository.save(new Loan(new BigDecimal("1500"), user3.getId()));
        loanRepository.save(new Loan(new BigDecimal("3500.50"), user3.getId()));

        loanRepository.save(new Loan(new BigDecimal("5500.55"), user4.getId()));
        logger.info("Initialize database finished");
    }

}
