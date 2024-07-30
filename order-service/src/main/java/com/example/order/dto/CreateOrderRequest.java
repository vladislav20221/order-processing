package com.example.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateOrderRequest {
    @NotNull
    @Schema(description = "product uid", requiredMode = Schema.RequiredMode.REQUIRED)
    private String productUid;
    @NotNull
    @Positive
    @Schema(description = "product quantity", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer quantity;
    @NotNull
    @Positive
    @Schema(description = "product price", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer price;
}