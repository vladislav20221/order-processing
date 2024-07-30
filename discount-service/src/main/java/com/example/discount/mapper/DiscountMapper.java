package com.example.discount.mapper;

import com.example.discount.dto.CreateDiscountRequestDto;
import com.example.discount.dto.DiscountDto;
import com.example.discount.entity.DiscountEntity;
import com.example.discount.model.DiscountFilter;
import com.example.domain.dto.discount.DiscountRequestDto;
import com.example.domain.dto.discount.DiscountResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DiscountMapper {

    DiscountEntity map(CreateDiscountRequestDto request);

    @Mapping(target = "currentDateTime", expression = "java(java.time.LocalDateTime.now())")
    DiscountFilter map(DiscountRequestDto request);

    DiscountDto map(DiscountEntity entity);

    @Mapping(target = "productQuantity", source = "request.quantity")
    DiscountResponseDto mapDiscountResponse(
            DiscountRequestDto request,
            Long discountValue,
            Long priceAfterDiscount
    );

}