package com.example.discount.service;

import com.example.discount.dto.DiscountDto;
import com.example.domain.dto.discount.DiscountRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface DiscountPolicy {

    Long calculation(
            @NotNull @Valid DiscountDto discount,
            @NotNull @Valid DiscountRequestDto request
    );

}