package com.cash.demo.repository;

import com.cash.demo.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Page<Loan> findLoansByUserId(Long userId, Pageable pageable);
    List<Loan> findLoansByUserId(Long userId);
    
}
