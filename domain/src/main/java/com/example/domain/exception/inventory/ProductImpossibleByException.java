package com.example.domain.exception.inventory;

import com.example.domain.exception.ConflictException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
public class ProductImpossibleByException extends ConflictException {
    public static final String MESSAGE_TEMPLATE = "product [%s] not enough: quantity = [%s] count = [%s]";
    private final String message;

    public ProductImpossibleByException(final UUID uid, final int quantity, final int count) {
        this.message = MESSAGE_TEMPLATE.formatted(uid.toString(), quantity, count);
    }

}