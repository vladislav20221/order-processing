package com.example.domain.exception;

import com.example.domain.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public interface ResponseCodeError {
    HttpStatus getStatus();
    ErrorCode getCode();
    String getMessage();
}