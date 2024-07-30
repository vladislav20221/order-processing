package com.example.domain.exception;

import com.example.domain.enums.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class InvalidValueException extends ResponseCodeException {
    protected final HttpStatus status = HttpStatus.BAD_REQUEST;
    protected final ErrorCode code = ErrorCode.INVALID_VALUE;
}