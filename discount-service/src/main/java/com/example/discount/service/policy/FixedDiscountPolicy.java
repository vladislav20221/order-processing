package com.example.discount.service.policy;

import com.example.discount.dto.DiscountDto;
import com.example.discount.service.DiscountPolicy;
import com.example.domain.dto.discount.DiscountRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("FIXED")
@RequiredArgsConstructor
public class FixedDiscountPolicy implements DiscountPolicy {

    @Override
    public Long calculation(
            final DiscountDto discount,
            final DiscountRequestDto request
    ) {
        return discount.getDiscountValue();
    }

}