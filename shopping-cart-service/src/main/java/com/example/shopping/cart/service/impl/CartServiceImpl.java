package com.example.shopping.cart.service.impl;

import com.example.domain.dto.cart.AddCartItemRequestDto;
import com.example.domain.dto.cart.CartDto;
import com.example.domain.dto.cart.InitCartRequestDto;
import com.example.domain.dto.cart.UpdateCartItemRequestDto;
import com.example.domain.exception.cart.CartItemNotFoundException;
import com.example.domain.exception.cart.CartUserNotFoundException;
import com.example.shopping.cart.entity.CartEntity;
import com.example.shopping.cart.entity.CartItemEntity;
import com.example.shopping.cart.mapper.CartMapper;
import com.example.shopping.cart.repository.CartItemRepository;
import com.example.shopping.cart.repository.CartRepository;
import com.example.shopping.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartMapper mapper;
    private final CartRepository repository;
    private final CartItemRepository cartItemRepository;

    @Override
    public CartDto getCart(final UUID userUid) {
        return mapper.map(tryFindByUserUid(userUid));
    }

    @Override
    public CartDto initCart(final InitCartRequestDto request) {
        final CartEntity entity = mapper.map(request);
        return mapper.map(repository.save(entity));
    }

    @Override
    public CartDto addCartItem(final UUID userUid, final AddCartItemRequestDto request) {
        final CartEntity cart = tryFindByUserUid(userUid);
        final CartItemEntity cartItem = mapper.map(request);
        cart.getCarts().add(cartItem);

        return mapper.map(cart);
    }

    @Override
    public CartDto updateCartItem(
            final UUID userUid,
            final Long cartId,
            final UpdateCartItemRequestDto request
    ) {
        final CartItemEntity entity = tryFindCartItemById(cartId, userUid);
        entity.setQuantity(request.getQuantity());
        entity.setOrderUid(UUID.fromString(request.getOrderUid()));
        entity.setProductUid(UUID.fromString(request.getProductUid()));
        return mapper.map(entity.getCart());
    }

    @Override
    public CartDto removeCartItem(
            final UUID userUid,
            final Long cartId
    ) {
        final CartItemEntity entity = tryFindCartItemById(cartId, userUid);
        cartItemRepository.delete(entity);
        return mapper.map(entity.getCart());
    }

    @Override
    public void deleteCarts(final UUID userUid) {
        repository.deleteByUserUid(userUid);
    }

    @Override
    public void block(final UUID userUid) {
        final CartEntity cart = tryFindByUserUid(userUid);
        cart.setIsBlocked(true);
    }

    @Override
    public void unblock(final UUID userUid) {
        final CartEntity cart = tryFindByUserUid(userUid);
        cart.setIsBlocked(false);
    }

    private CartEntity tryFindByUserUid(final UUID userUid) {
        return repository.findByUserUid(userUid)
                .orElseThrow(() -> new CartUserNotFoundException(userUid));
    }

    private CartItemEntity tryFindCartItemById(final Long id, final UUID userUid) {
        final CartItemEntity entity =  cartItemRepository.findById(id)
                .orElseThrow(() -> new CartItemNotFoundException(id, userUid));
        if (entity.getCart().getUserUid().compareTo(userUid) != 0) {
            throw new CartItemNotFoundException(id, userUid);
        }
        return entity;
    }

}