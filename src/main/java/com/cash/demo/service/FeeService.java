package com.cash.demo.service;

import com.cash.demo.entity.Fee;
import com.cash.demo.entity.Loan;

import java.util.List;

public interface FeeService {

    List<Fee> quotaGenerator(Loan loan);

}
