package com.example.order.dto;

import com.example.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class OrderDto {
    @Schema(description = "order id")
    private Long id;
    @Schema(description = "order created at")
    private LocalDateTime createdAt;
    @Schema(description = "order modified at")
    private LocalDateTime modifiedAt;
    @Schema(description = "product uid")
    private UUID productUid;
    @Schema(description = "product quantity")
    private Integer quantity;
    @Schema(description = "product price")
    private Integer price;
    @Schema(description = "order status")
    private OrderStatus status;
}