package com.example.domain.exception;

import com.example.domain.enums.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class NotFoundException extends ResponseCodeException {
    protected final HttpStatus status = HttpStatus.NOT_FOUND;
    protected final ErrorCode code = ErrorCode.NOT_FOUND;
}