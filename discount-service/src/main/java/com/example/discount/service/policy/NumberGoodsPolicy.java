package com.example.discount.service.policy;

import com.example.discount.dto.DiscountDto;
import com.example.discount.service.DiscountPolicy;
import com.example.domain.dto.discount.DiscountRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("NUMBER_OF_GOODS")
@RequiredArgsConstructor
public class NumberGoodsPolicy implements DiscountPolicy {

    @Override
    public Long calculation(
            final DiscountDto discount,
            final DiscountRequestDto request
    ) {
        return request.getPrice();
    }

}