package com.example.discount.dto;

import com.example.discount.enums.DiscountType;
import com.example.domain.enums.ProductCategory;
import com.example.domain.enums.UserGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DiscountDto {
    @PositiveOrZero
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private DiscountType discountType;
    private Long discountValue;
    private Long orderAmountMin;
    private Long orderAmountMax;
    private Long orderQuantity;
    private UUID userUid;
    private UserGroup userGroup;
    private ProductCategory productCategory;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isActive;
    private Boolean isAllUsers;
    private Boolean isAllGroup;
    private Boolean isAllCategory;
}