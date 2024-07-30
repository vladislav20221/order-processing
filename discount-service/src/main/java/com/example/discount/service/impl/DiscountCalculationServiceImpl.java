package com.example.discount.service.impl;

import com.example.discount.dto.DiscountDto;
import com.example.discount.mapper.DiscountMapper;
import com.example.discount.model.DiscountFilter;
import com.example.discount.service.DiscountCalculationService;
import com.example.discount.service.DiscountPolicy;
import com.example.discount.service.DiscountService;
import com.example.domain.dto.discount.DiscountRequestDto;
import com.example.domain.dto.discount.DiscountResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiscountCalculationServiceImpl implements DiscountCalculationService {
    private final DiscountService service;
    private final DiscountMapper mapper;
    private final Map<String, DiscountPolicy> policyMap;

    @Override
    public DiscountResponseDto calculation(final DiscountRequestDto request) {
        final DiscountFilter filter = mapper.map(request);
        final List<DiscountDto> discounts = service.findAllFilters(filter);

        long discountValue = 0L;
        for (int i = 0; i < request.getQuantity(); i++) {
            for (DiscountDto discount : discounts) {
                final DiscountPolicy policy =
                        this.policyMap.get(discount.getDiscountType().toString());
                Objects.requireNonNull(policy, "discount policy [%s] unsupported".formatted(discount.getDiscountType().toString()));
                discountValue += policy.calculation(discount, request);
            }
            log.info("calculation discount: {}", discountValue);
        }
        final long totalPrice = request.getPrice() * request.getQuantity();
        return mapper.mapDiscountResponse(request, discountValue, calculationDiscount(totalPrice, discountValue));
    }

    private long calculationDiscount(final long totalPrice, final long discount) {
        final long priceAfterDiscount = totalPrice - discount;
        return Math.max(priceAfterDiscount, 0);
    }

}