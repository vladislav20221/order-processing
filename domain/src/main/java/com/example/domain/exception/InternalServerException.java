package com.example.domain.exception;

import com.example.domain.enums.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class InternalServerException extends ResponseCodeException {
    protected final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    protected final ErrorCode code = ErrorCode.INTERNAL_SERVER_ERROR;
}