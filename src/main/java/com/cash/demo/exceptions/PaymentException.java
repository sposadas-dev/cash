package com.cash.demo.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentException extends RuntimeException  {

    public PaymentException(String message) {
        super(message);
    }

}
