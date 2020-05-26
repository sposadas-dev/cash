package com.cash.demo.service.impl;

import com.cash.demo.entity.Fee;
import com.cash.demo.entity.Interest;
import com.cash.demo.entity.Loan;
import com.cash.demo.repository.InterestRepository;
import com.cash.demo.service.FeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeeServiceImpl implements FeeService {

    private final Logger logger = LoggerFactory.getLogger(FeeServiceImpl.class);

    @Autowired
    private InterestRepository interestRepository;

    @Override
    public List<Fee> quotaGenerator(Loan loan) {
        logger.info("Quota generator");
        List<Fee> fees = new ArrayList<>();
        logger.warn("Search interest percentage from {} fees in database", loan.getNumberFee());
        Interest interest = interestRepository.findByFee(loan.getNumberFee());
        BigDecimal loanWithInterest = getLoanWithInterest(loan, interest);
        for (int i = 1; i <= loan.getNumberFee(); i++) {
            fees.add(new Fee(i, loan.getId(), loanWithInterest, LocalDateTime.now().plusMonths(i)));
        }
        return fees;
    }

    private BigDecimal getLoanWithInterest(Loan loan, Interest interest) {
        logger.info("Calculate loan with interest");
        return BigDecimal.valueOf(Math.ceil((loan.getAmount().doubleValue() + (loan.getAmount().doubleValue() * (interest.getInterest() / 100))) /
                loan.getNumberFee()));
    }

}
