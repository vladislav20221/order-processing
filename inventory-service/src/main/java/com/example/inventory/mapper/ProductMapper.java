package com.example.inventory.mapper;

import com.example.inventory.dto.CreateProductRequest;
import com.example.inventory.dto.ProductDto;
import com.example.inventory.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    ProductDto map(ProductEntity entity);

    ProductEntity mapToEntity(ProductDto dto);

    ProductEntity map(CreateProductRequest request);

}