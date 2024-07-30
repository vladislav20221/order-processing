package com.example.domain.exception;

import com.example.domain.enums.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class AlreadyExistsException extends ResponseCodeException {
    protected final HttpStatus status = HttpStatus.CONFLICT;
    protected final ErrorCode code = ErrorCode.ALREADY_EXISTS;
}