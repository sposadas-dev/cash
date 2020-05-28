package com.cash.demo.repository;

import com.cash.demo.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>{

    List<Payment> findAllByPaymentDateBetween(LocalDateTime paymentDate, LocalDateTime paymentDate2);
    Payment findByCode(String code);

}
