package com.cash.demo.service.impl;

import com.cash.demo.entity.Payment;
import com.cash.demo.repository.PaymentRepository;
import com.cash.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment getDetailPayment(String code) {
        return paymentRepository.findByCode(code);
    }

    @Override
    public List<Payment> getPayments(LocalDate dateFrom, LocalDate dateUntil) {
        return paymentRepository.findAllByPaymentDateBetween(dateFrom.atStartOfDay(), dateUntil.atTime(23, 59, 59));
    }


}
