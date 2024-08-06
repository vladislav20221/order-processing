package com.example.shopping.cart.mapper;

import com.example.domain.dto.cart.AddCartItemRequestDto;
import com.example.domain.dto.cart.CartDto;
import com.example.domain.dto.cart.CartItemDto;
import com.example.domain.dto.cart.InitCartRequestDto;
import com.example.shopping.cart.entity.CartEntity;
import com.example.shopping.cart.entity.CartItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CartMapper {

    CartDto map(CartEntity entity);

    CartItemDto map(CartItemEntity entity);

    CartEntity map(InitCartRequestDto request);

    CartItemEntity map(AddCartItemRequestDto request);

}