package com.example.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex) {
        return ResponseEntity.status(ex.getStatusCode())
            .body(new ErrorResponse(ex.getStatusCode(), ex.getMessage()));
    }

    static class ErrorResponse {
        public int transactionStatusCode;
        public String transactionStatusDescription;

        public ErrorResponse(int transactionStatusCode, String transactionStatusDescription) {
            this.transactionStatusCode = transactionStatusCode;
            this.transactionStatusDescription = transactionStatusDescription;
        }
    }
}