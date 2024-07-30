package com.example.domain.exception.inventory;

import com.example.domain.exception.ConflictException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
public class ProductBlockingException extends ConflictException {
    public static final String MESSAGE_TEMPLATE = "product [%s] is blocked";
    private final String message;

    public ProductBlockingException(final UUID uid) {
        this.message = MESSAGE_TEMPLATE.formatted(uid.toString());
    }

}