package com.example.domain.exception.discount;

import com.example.domain.exception.NotFoundException;
import lombok.Getter;

@Getter
public class DiscountNotFoundException extends NotFoundException {
    public static final String MESSAGE_TEMPLATE = "discount by id [%s] not found";
    private final String message;

    public DiscountNotFoundException(final Long id) {
        this.message = MESSAGE_TEMPLATE.formatted(id);
    }

}