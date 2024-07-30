package com.example.domain.controller.handler;

import com.example.domain.dto.ErrorMessageDto;
import com.example.domain.enums.ErrorCode;
import com.example.domain.exception.ResponseCodeException;
import com.example.domain.mapper.ErrorMessageMapper;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExternalExceptionFilter {
    private final ErrorMessageMapper mapper;

    @ExceptionHandler({
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class,
            BindException.class
    })
    public ResponseEntity<ErrorMessageDto> handleValidation(
            final Exception exception
    ) {
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        final ErrorMessageDto message = ErrorMessageDto.builder()
                .code(ErrorCode.INVALID_VALUE.toString())
                .message(exception.getMessage())
                .status(status.name())
                .build();
        log.warn(exception.getMessage());
        return ResponseEntity.status(status).body(message);
    }

    @ExceptionHandler(ResponseCodeException.class)
    public ResponseEntity<ErrorMessageDto> handleResponseCode(
            final ResponseCodeException exception
    ) {
        final ErrorMessageDto message = this.mapper.map(exception);
        log.warn(exception.getMessage());
        return ResponseEntity.status(exception.getStatus()).body(message);
    }

}