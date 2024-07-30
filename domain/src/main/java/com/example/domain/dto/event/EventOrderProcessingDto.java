package com.example.domain.dto.event;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EventOrderProcessingDto {
    @Schema(description = "event uid")
    private String eventUid;
    @Schema(description = "product uid")
    private String productUid;
    @Schema(description = "product price")
    private Integer price;
    @Schema(description = "product quantity")
    private Integer quantity;
}