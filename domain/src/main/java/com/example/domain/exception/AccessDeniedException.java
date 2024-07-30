package com.example.domain.exception;

import com.example.domain.enums.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class AccessDeniedException extends ResponseCodeException {
    protected final HttpStatus status = HttpStatus.FORBIDDEN;
    protected final ErrorCode code = ErrorCode.ACCESS_DENIED;
}