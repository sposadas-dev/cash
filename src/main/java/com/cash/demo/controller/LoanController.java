package com.cash.demo.controller;

import com.cash.demo.entity.Loan;
import com.cash.demo.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoanController {

    private final Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private LoanService loanService;

    @GetMapping("/loans")
    public Page<Loan> allLoans(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam(required = false) Long userId){
        logger.info("Get all loans");
        Pageable pageable = PageRequest.of(page, size);
        return loanService.findAllLoans(pageable, userId);
    }

    @PostMapping("/loans")
    public Loan addLoan(@Valid @RequestBody Loan newLoan) {
        logger.info("Add loan {}", newLoan);
        return loanService.saveLoan(newLoan);
    }

}
