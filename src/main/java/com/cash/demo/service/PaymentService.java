package com.cash.demo.service;

import com.cash.demo.entity.Payment;

import java.time.LocalDate;
import java.util.List;

public interface PaymentService {

    Payment getDetailPayment(String code);
    List<Payment> getPayments(LocalDate dateFrom, LocalDate dateUntil);

}
