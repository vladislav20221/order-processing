package com.example.domain.exception.cart;

import com.example.domain.exception.NotFoundException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CartUserNotFoundException extends NotFoundException {
    public static final String MESSAGE_TEMPLATE = "cart by user uid [%s] not found";
    private final String message;

    public CartUserNotFoundException(final UUID uid) {
        this.message = MESSAGE_TEMPLATE.formatted(uid.toString());
    }

}