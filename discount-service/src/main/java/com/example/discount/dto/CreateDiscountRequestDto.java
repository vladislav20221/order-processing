package com.example.discount.dto;

import com.example.discount.enums.DiscountType;
import com.example.domain.enums.ProductCategory;
import com.example.domain.enums.UserGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateDiscountRequestDto {
    private DiscountType discountType;
    private Integer discountValue;
    private Integer orderAmountMin;
    private Integer orderAmountMax;
    private Integer orderQuantity;
    @UUID
    private String userUid;
    private UserGroup userGroup;
    private ProductCategory productCategory;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isActive;
    private Boolean isAllUsers;
    private Boolean isAllGroup;
    private Boolean isAllCategory;
}