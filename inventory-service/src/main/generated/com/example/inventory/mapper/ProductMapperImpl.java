package com.example.inventory.mapper;

import com.example.inventory.dto.CreateProductRequest;
import com.example.inventory.dto.ProductDto;
import com.example.inventory.entity.ProductEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-06T13:16:06+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto map(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        if ( entity.getId() != null ) {
            productDto.setId( entity.getId().toString() );
        }
        productDto.setName( entity.getName() );
        productDto.setDescription( entity.getDescription() );
        productDto.setQuantity( entity.getQuantity() );
        productDto.setSoldCount( entity.getSoldCount() );
        productDto.setPrice( entity.getPrice() );
        productDto.setCategory( entity.getCategory() );
        productDto.setIsBlocked( entity.getIsBlocked() );

        return productDto;
    }

    @Override
    public ProductEntity mapToEntity(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        if ( dto.getId() != null ) {
            productEntity.id( UUID.fromString( dto.getId() ) );
        }
        productEntity.name( dto.getName() );
        productEntity.description( dto.getDescription() );
        productEntity.quantity( dto.getQuantity() );
        productEntity.soldCount( dto.getSoldCount() );
        productEntity.price( dto.getPrice() );
        productEntity.category( dto.getCategory() );
        productEntity.isBlocked( dto.getIsBlocked() );

        return productEntity.build();
    }

    @Override
    public ProductEntity map(CreateProductRequest request) {
        if ( request == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.name( request.getName() );
        productEntity.description( request.getDescription() );
        productEntity.quantity( request.getQuantity() );
        productEntity.price( request.getPrice() );
        productEntity.category( request.getCategory() );

        return productEntity.build();
    }
}
