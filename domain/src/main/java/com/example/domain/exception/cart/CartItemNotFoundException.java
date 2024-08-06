package com.example.domain.exception.cart;

import com.example.domain.exception.NotFoundException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CartItemNotFoundException extends NotFoundException {
    public static final String MESSAGE_TEMPLATE = "cart by id [%s] not found for user: [%s]";
    private final String message;

    public CartItemNotFoundException(final Long id, final UUID userUid) {
        this.message = MESSAGE_TEMPLATE.formatted(id, userUid.toString());
    }

}