package com.cash.demo.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentAlreadyMadeException extends RuntimeException  {

    public PaymentAlreadyMadeException(String message) {
        super(message);
    }

}
