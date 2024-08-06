package com.example.domain.exception.cart;

import com.example.domain.exception.NotFoundException;
import lombok.Getter;

@Getter
public class CartNotFoundException extends NotFoundException {
    public static final String MESSAGE_TEMPLATE = "cart by id [%s] not found";
    private final String message;

    public CartNotFoundException(final Long id) {
        this.message = MESSAGE_TEMPLATE.formatted(id);
    }

}