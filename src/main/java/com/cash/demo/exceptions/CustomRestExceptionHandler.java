package com.cash.demo.exceptions;

import com.cash.demo.error.ApiError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error, getUri(request));
        return getObjectResponseEntity(apiError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND, "Entity not exists", ex.getLocalizedMessage(), getUri(request));
        return getObjectResponseEntity(apiError);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleEntityNotFound(ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation cv : new ArrayList<>(ex.getConstraintViolations())) {
            errors.add(cv.getPropertyPath() + ": " + cv.getMessage());
        }
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Validation Failed", errors, getUri(request));
        return getObjectResponseEntity(apiError);
    }

    @ExceptionHandler(PaymentAlreadyMadeException.class)
    protected ResponseEntity<Object> handleEntityNotFound(PaymentAlreadyMadeException ex, WebRequest request) {
        //TODO: Verificar si la respuesta de error es la correcta.
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.CONFLICT, "Payment already made", ex.getLocalizedMessage(), getUri(request));
        return getObjectResponseEntity(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            errors.add(objectError.getDefaultMessage());
        }
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Validation Failed", errors, getUri(request));
        return getObjectResponseEntity(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error, getUri(request));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    private ResponseEntity<Object> getObjectResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    private String getUri(WebRequest request) {
        return ((ServletWebRequest) request).getRequest().getRequestURI();
    }

}
