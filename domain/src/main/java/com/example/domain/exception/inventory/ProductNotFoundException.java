package com.example.domain.exception.inventory;

import com.example.domain.exception.NotFoundException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ProductNotFoundException extends NotFoundException {
    public static final String MESSAGE_TEMPLATE = "product [%s] not found";
    private final String message;

    public ProductNotFoundException(final UUID uid) {
        this.message = MESSAGE_TEMPLATE.formatted(uid.toString());
    }

}