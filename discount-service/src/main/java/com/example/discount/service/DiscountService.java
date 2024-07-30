package com.example.discount.service;

import com.example.discount.dto.CreateDiscountRequestDto;
import com.example.discount.dto.DiscountDto;
import com.example.discount.model.DiscountFilter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface DiscountService {

    DiscountDto create(@Valid CreateDiscountRequestDto request);

    DiscountDto findById(@NotNull @PositiveOrZero Long id);

    List<DiscountDto> findAll();

    List<DiscountDto> findAllFilters(DiscountFilter filter);

    Page<DiscountDto> findAllPage(@NotNull PageRequest pageable);

    void deleteById(@NotNull @PositiveOrZero Long id);

    void activate(@NotNull @PositiveOrZero Long id);

    void deactivate(@NotNull @PositiveOrZero Long id);

}