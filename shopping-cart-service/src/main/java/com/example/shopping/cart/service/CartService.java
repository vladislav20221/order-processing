package com.example.shopping.cart.service;

import com.example.domain.dto.cart.AddCartItemRequestDto;
import com.example.domain.dto.cart.CartDto;
import com.example.domain.dto.cart.InitCartRequestDto;
import com.example.domain.dto.cart.UpdateCartItemRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
public interface CartService {

    CartDto getCart(@NotNull UUID userUid);

    CartDto initCart(@NotNull @Valid InitCartRequestDto request);

    CartDto addCartItem(
            @NotNull UUID userUid,
            @NotNull @Valid AddCartItemRequestDto request
    );

    CartDto updateCartItem(
            @NotNull UUID userUid,
            @NotNull @PositiveOrZero Long cartId,
            @NotNull @Valid UpdateCartItemRequestDto request
    );

    CartDto removeCartItem(
            @NotNull UUID userUid,
            @NotNull @PositiveOrZero Long cartId
    );

    void deleteCarts(@NotNull UUID userUid);

    void block(@NotNull UUID userUid);

    void unblock(@NotNull UUID userUid);

}