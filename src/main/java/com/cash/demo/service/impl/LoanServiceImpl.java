package com.cash.demo.service.impl;

import com.cash.demo.entity.Loan;
import com.cash.demo.repository.LoanRepository;
import com.cash.demo.repository.UserRepository;
import com.cash.demo.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class LoanServiceImpl implements LoanService {

    private final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Loan> findAllLoans(Pageable pageable, Long userId) {
        if (userId != null) {
            if (!userRepository.findById(userId).isPresent()) {
                throw new EntityNotFoundException("userId: " + userId + " not exists");
            }
            logger.warn("Search loans from userId: {} from database", userId);
            return loanRepository.findLoansByUserId(userId, pageable);
        }
        logger.warn("Search all loans from database");
        return loanRepository.findAll(pageable);
    }

    @Override
    public Loan saveLoan(Loan newLoan) {
        if (!userRepository.findById(newLoan.getUserId()).isPresent()) {
            throw new EntityNotFoundException("To add a loan the user must exist userId: " + newLoan.getUserId());
        }
        logger.warn("Save loan {} in database from userId: {}", newLoan, newLoan.getUserId());
        return loanRepository.save(newLoan);
    }

}
