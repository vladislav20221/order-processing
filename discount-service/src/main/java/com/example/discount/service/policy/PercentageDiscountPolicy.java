package com.example.discount.service.policy;

import com.example.discount.dto.DiscountDto;
import com.example.discount.service.DiscountPolicy;
import com.example.domain.dto.discount.DiscountRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Slf4j
@Service("PERCENTAGE")
@RequiredArgsConstructor
public class PercentageDiscountPolicy implements DiscountPolicy {

    @Override
    public Long calculation(
            final DiscountDto discount,
            final DiscountRequestDto request
    ) {
        final BigDecimal percentage =
                BigDecimal.valueOf(discount.getDiscountValue());
        final BigDecimal totalPrice =
                BigDecimal.valueOf(request.getPrice() * request.getQuantity());
        return totalPrice.multiply(
                percentage.divide(BigDecimal.valueOf(100), MathContext.DECIMAL64)
        ).longValue();
    }

}