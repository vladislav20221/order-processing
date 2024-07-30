package com.example.discount.controller;

import com.example.discount.service.DiscountCalculationService;
import com.example.domain.dto.discount.DiscountRequestDto;
import com.example.domain.dto.discount.DiscountResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculate")
@RequiredArgsConstructor
public class DiscountCalculationControllerV1 {
    private final DiscountCalculationService service;

    @PatchMapping("")
    public DiscountResponseDto calculation(
            @RequestBody final DiscountRequestDto request
    ) {
        return this.service.calculation(request);
    }

}