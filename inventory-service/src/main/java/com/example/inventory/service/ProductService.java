package com.example.inventory.service;

import com.example.inventory.dto.CreateProductRequest;
import com.example.inventory.dto.ProductDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductService {

    Page<ProductDto> getPage(@NotNull PageRequest pageRequest);

    Page<ProductDto> getPage(@NotNull Integer page, @NotNull Integer size);

    List<ProductDto> getAll();

    ProductDto findByUid(@NotNull @UUID String uid);

    ProductDto create(@Valid CreateProductRequest request);

    ProductDto updatePrice(@NotNull @UUID String uid, @Positive Integer price);

    ProductDto updateQuantity(@NotNull @UUID String uid, @Positive Integer quantity);

    void delete(@NotNull @UUID String uid);

    void block(@NotNull @UUID String uid);

    void unlock(@NotNull @UUID String uid);

    void by(@NotNull @UUID String uid, @Positive Integer count);

}