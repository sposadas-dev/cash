package com.cash.demo.service;

import com.cash.demo.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoanService {

    Page<Loan> findAllLoans(Pageable pageable, Long userId);

    Loan saveLoan(Loan newLoan);

}
