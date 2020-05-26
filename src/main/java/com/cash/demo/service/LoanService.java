package com.cash.demo.service;

import com.cash.demo.entity.Loan;
import com.cash.demo.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoanService {

    Page<Loan> findAllLoans(Pageable pageable, Long userId);

    Loan saveLoan(Loan newLoan);

    Loan savePayment(Long loanId, Integer feeNumber, Payment payment);
}
