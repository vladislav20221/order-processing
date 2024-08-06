package com.example.shopping.cart.controller;

import com.example.domain.dto.cart.AddCartItemRequestDto;
import com.example.domain.dto.cart.CartDto;
import com.example.domain.dto.cart.InitCartRequestDto;
import com.example.domain.dto.cart.UpdateCartItemRequestDto;
import com.example.shopping.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shopping/carts")
@RequiredArgsConstructor
public class CartControllerV1 {
    private final CartService service;

    @GetMapping("/{uid}")
    public CartDto getCart(@PathVariable("uid") UUID userUid) {
        return this.service.getCart(userUid);
    }

    @PostMapping("")
    public CartDto initCart(@RequestBody InitCartRequestDto request) {
        return this.service.initCart(request);
    }

    @PatchMapping("/{uid}")
    public CartDto addCartItem(
            @PathVariable("uid") UUID userUid,
            @RequestBody AddCartItemRequestDto request
    ) {
        return this.service.addCartItem(userUid, request);
    }

    @PatchMapping("/{uid}/{cartId}")
    public CartDto updateCartItem(
            @PathVariable("uid") UUID userUid,
            @PathVariable("cartId") Long cartId,
            @RequestBody UpdateCartItemRequestDto request
    ) {
        return this.service.updateCartItem(userUid, cartId, request);
    }

    @DeleteMapping("/{uid}/{cartId}")
    public CartDto removeCartItem(
            @PathVariable("uid") UUID userUid,
            @PathVariable("cartId") Long cartId
    ) {
        return this.service.removeCartItem(userUid, cartId);
    }

    @DeleteMapping("/{uid}")
    public void deleteCarts(@PathVariable("uid") UUID userUid) {
        this.service.deleteCarts(userUid);
    }

    @PatchMapping("/{uid}/block")
    public void block(@PathVariable("uid") UUID userUid) {
        this.service.block(userUid);
    }

    @PatchMapping("/{uid}/unblock")
    public void unblock(@PathVariable("uid") UUID userUid) {
        this.service.unblock(userUid);
    }

}