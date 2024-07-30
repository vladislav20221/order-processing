package com.example.discount.model;

import com.example.domain.enums.ProductCategory;
import com.example.domain.enums.UserGroup;

import java.time.LocalDateTime;
import java.util.UUID;

public record DiscountFilter (
    LocalDateTime currentDateTime,
    UUID userUid,
    UserGroup userGroup,
    ProductCategory productCategory,
    Long price,
    Long quantity
) {};