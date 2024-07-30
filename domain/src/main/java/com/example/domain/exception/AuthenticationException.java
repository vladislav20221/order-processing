package com.example.domain.exception;

import com.example.domain.enums.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class AuthenticationException extends ResponseCodeException {
    protected final HttpStatus status = HttpStatus.UNAUTHORIZED;
    protected final ErrorCode code = ErrorCode.UNAUTHORIZED;
}