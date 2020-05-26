package com.cash.demo;

import com.cash.demo.entity.Fee;
import com.cash.demo.entity.Interest;
import com.cash.demo.entity.Loan;
import com.cash.demo.entity.User;
import com.cash.demo.repository.InterestRepository;
import com.cash.demo.repository.LoanRepository;
import com.cash.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private InterestRepository interestRepository;

    @Override
    public void run(String... args) {

        logger.info("Initialize database");
        User user1 = userRepository.save(new User("Eduardo", "Pochidis", "pochidis.e@gmail.com"));
        User user2 = userRepository.save(new User("Mariana", "Castaña", "castaña.m@gmail.com"));
        User user3 = userRepository.save(new User("Simon", "Pedro", "pedro.s@gmail.com"));
        User user4 = userRepository.save(new User("Sofia", "Veren", "veren.s@gmail.com"));

        interestRepository.save(new Interest(1, 10));
        interestRepository.save(new Interest(2, 20));
        interestRepository.save(new Interest(3, 30));
        interestRepository.save(new Interest(6, 40));
        interestRepository.save(new Interest(12, 60));
        interestRepository.save(new Interest(18, 70));
        interestRepository.save(new Interest(24, 90));

        Fee fee1loan1 = new Fee(1, 1L, BigDecimal.valueOf(1100), LocalDateTime.now().plusMonths(1));
        Fee fee2loan1 = new Fee(2, 1L, BigDecimal.valueOf(1100), LocalDateTime.now().plusMonths(2));
        Fee fee3loan1 = new Fee(3, 1L, BigDecimal.valueOf(1100), LocalDateTime.now().plusMonths(3));
        List<Fee> feesLoan1 = new ArrayList<>(Arrays.asList(fee1loan1, fee2loan1, fee3loan1));

        Fee fee1loan2 = new Fee(1, 2L, BigDecimal.valueOf(1000), LocalDateTime.now().plusMonths(1));
        Fee fee2loan2 = new Fee(2, 2L, BigDecimal.valueOf(1000), LocalDateTime.now().plusMonths(2));
        Fee fee3loan2 = new Fee(3, 2L, BigDecimal.valueOf(1000), LocalDateTime.now().plusMonths(3));
        Fee fee4loan2 = new Fee(4, 2L, BigDecimal.valueOf(1000), LocalDateTime.now().plusMonths(4));
        Fee fee5loan2 = new Fee(5, 2L, BigDecimal.valueOf(1000), LocalDateTime.now().plusMonths(5));
        Fee fee6loan2 = new Fee(6, 2L, BigDecimal.valueOf(1000), LocalDateTime.now().plusMonths(6));
        List<Fee> feesLoan2 = new ArrayList<>(Arrays.asList(fee1loan2, fee2loan2, fee3loan2, fee4loan2, fee5loan2, fee6loan2));

        Fee fee1loan3 = new Fee(1, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(1));
        Fee fee2loan3 = new Fee(2, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(2));
        Fee fee3loan3 = new Fee(3, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(3));
        Fee fee4loan3 = new Fee(4, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(4));
        Fee fee5loan3 = new Fee(5, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(5));
        Fee fee6loan3 = new Fee(6, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(6));
        Fee fee7loan3 = new Fee(7, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(7));
        Fee fee8loan3 = new Fee(8, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(8));
        Fee fee9loan3 = new Fee(9, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(9));
        Fee fee10loan3 = new Fee(10, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(10));
        Fee fee11loan3 = new Fee(11, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(11));
        Fee fee12loan3 = new Fee(12, 3L, BigDecimal.valueOf(2333.33), LocalDateTime.now().plusMonths(12));
        List<Fee> feesLoan3 = new ArrayList<>(Arrays.asList(fee1loan3, fee2loan3, fee3loan3, fee4loan3, fee5loan3, fee6loan3,
                                                            fee7loan3, fee8loan3, fee9loan3, fee10loan3, fee11loan3, fee12loan3));

        Fee fee1loan4 = new Fee(1, 4L, BigDecimal.valueOf(2200), LocalDateTime.now().plusMonths(1));
        Fee fee2loan4 = new Fee(2, 4L, BigDecimal.valueOf(2200), LocalDateTime.now().plusMonths(2));
        Fee fee3loan4 = new Fee(3, 4L, BigDecimal.valueOf(2200), LocalDateTime.now().plusMonths(3));
        List<Fee> feesLoan4 = new ArrayList<>(Arrays.asList(fee1loan4, fee2loan4, fee3loan4));

        loanRepository.save(new Loan(1L, user1.getId(), BigDecimal.valueOf(3000), 3, feesLoan1));
        loanRepository.save(new Loan(2L, user2.getId(), BigDecimal.valueOf(5000), 6, feesLoan2));
        loanRepository.save(new Loan(3L, user3.getId(), BigDecimal.valueOf(20000), 12, feesLoan3));
        loanRepository.save(new Loan(4L, user4.getId(), BigDecimal.valueOf(6000), 3, feesLoan4));

        logger.info("Initialize database finished");
    }

}
