package com.cash.demo.controller;

import com.cash.demo.entity.Loan;
import com.cash.demo.entity.Payment;
import com.cash.demo.service.LoanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Api(value = "Loan Management System")
@RestController
@Validated
public class LoanController {

    private final Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private LoanService loanService;

    @ApiOperation(value = "View a page from list of available loans", response = Page.class)
    @GetMapping("/loans")
    public Page<Loan> allLoans(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam(required = false) Long userId) {
        logger.info("Get all loans");
        Pageable pageable = PageRequest.of(page, size);
        return loanService.findAllLoans(pageable, userId);
    }

    @ApiOperation(value = "Add loan from user", response = Loan.class)
    @PostMapping("/loans")
    public Loan addLoan(@Valid @RequestBody Loan newLoan) {
        logger.info("Add loan {}", newLoan);
        return loanService.saveLoan(newLoan);
    }

    @ApiOperation(value = "Pay the fees from loan")
    @PostMapping("/loans/{loanId}/fees/{feeNumber}")
    public Loan paymentFee(@PathVariable @Min(1) Long loanId, @PathVariable @Min(1) Integer feeNumber, @Valid @RequestBody Payment payment) {
        logger.info("Add payment from Loan {} and Fee {}", loanId, feeNumber);
        return loanService.savePayment(loanId, feeNumber, payment);
    }

}
