package com.example.discount.service;

import com.example.domain.dto.discount.DiscountRequestDto;
import com.example.domain.dto.discount.DiscountResponseDto;
import jakarta.validation.Valid;

public interface DiscountCalculationService {

    DiscountResponseDto calculation(@Valid DiscountRequestDto request);

}