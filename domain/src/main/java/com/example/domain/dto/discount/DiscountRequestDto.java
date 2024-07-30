package com.example.domain.dto.discount;

import com.example.domain.enums.ProductCategory;
import com.example.domain.enums.UserGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DiscountRequestDto {
    @UUID @NotNull
    @Schema(description = "event uid")
    private String userUid;
    @UUID @NotNull
    @Schema(description = "order uid")
    private String ordersUid;
    @Schema(description = "event uid")
    private UserGroup userGroup;
    @Schema(description = "product uid")
    private ProductCategory productCategory;
    @Schema(description = "product price")
    private Long price;
    @Schema(description = "product quantity")
    private Long quantity;
}