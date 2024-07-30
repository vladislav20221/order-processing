package com.example.domain.dto.discount;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UUID;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DiscountResponseDto {
    @UUID
    @NotNull
    @NotBlank
    private String orderUid;
    @Schema(description = "product price")
    private Long price;
    @Schema(description = "product price")
    private Long totalPrice;
    @Schema(description = "discount value")
    private Long discountValue;
    @Schema(description = "price after discount")
    private Long priceAfterDiscount;
    @Schema(description = "product quantity")
    private Long productQuantity;
}