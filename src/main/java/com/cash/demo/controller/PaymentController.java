package com.cash.demo.controller;

import com.cash.demo.entity.Payment;
import com.cash.demo.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Api(value = "Payments Management System")
@RestController
public class PaymentController {

    private final static Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @ApiOperation(value = "Get details from payment by code")
    @GetMapping("/payments/{code}")
    public Payment getDetailsPayment(@PathVariable String code) {
        logger.info("Get details from payment by code {}", code);
        return paymentService.getDetailPayment(code);
    }

    @ApiOperation(value = "Get payments by date from and date until")
    @GetMapping("/payments")
    public List<Payment> getPayments(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate dateUntil) {
        logger.info("Get payments from the date from {} and date until {}", dateFrom, dateUntil);
        return paymentService.getPayments(dateFrom, dateUntil);
    }

}
