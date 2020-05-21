package com.cash.demo.error;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;

@Data
public class ApiError {

    private LocalDateTime localDateTime;
    private HttpStatus status;
    private String message;
    private List<String> errors;
    private String path;

    public ApiError(LocalDateTime localDateTime,HttpStatus status, String message, List<String> errors, String path) {
        super();
        this.localDateTime = localDateTime;
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.path = path;
    }

    public ApiError(LocalDateTime localDateTime, HttpStatus status, String message, String error, String path) {
        super();
        this.localDateTime = localDateTime;
        this.status = status;
        this.message = message;
        this.path = path;
        errors = Arrays.asList(error);
    }
}