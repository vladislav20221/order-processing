package com.example.discount.mapper;

import com.example.discount.dto.CreateDiscountRequestDto;
import com.example.discount.dto.DiscountDto;
import com.example.discount.entity.DiscountEntity;
import com.example.discount.model.DiscountFilter;
import com.example.domain.dto.discount.DiscountRequestDto;
import com.example.domain.dto.discount.DiscountResponseDto;
import com.example.domain.enums.ProductCategory;
import com.example.domain.enums.UserGroup;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T15:47:21+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class DiscountMapperImpl implements DiscountMapper {

    @Override
    public DiscountEntity map(CreateDiscountRequestDto request) {
        if ( request == null ) {
            return null;
        }

        DiscountEntity discountEntity = new DiscountEntity();

        discountEntity.setDiscountType( request.getDiscountType() );
        if ( request.getDiscountValue() != null ) {
            discountEntity.setDiscountValue( request.getDiscountValue().longValue() );
        }
        if ( request.getOrderAmountMin() != null ) {
            discountEntity.setOrderAmountMin( request.getOrderAmountMin().longValue() );
        }
        if ( request.getOrderAmountMax() != null ) {
            discountEntity.setOrderAmountMax( request.getOrderAmountMax().longValue() );
        }
        if ( request.getOrderQuantity() != null ) {
            discountEntity.setOrderQuantity( request.getOrderQuantity().longValue() );
        }
        if ( request.getUserUid() != null ) {
            discountEntity.setUserUid( UUID.fromString( request.getUserUid() ) );
        }
        discountEntity.setUserGroup( request.getUserGroup() );
        discountEntity.setProductCategory( request.getProductCategory() );
        discountEntity.setStartDate( request.getStartDate() );
        discountEntity.setEndDate( request.getEndDate() );

        return discountEntity;
    }

    @Override
    public DiscountFilter map(DiscountRequestDto request) {
        if ( request == null ) {
            return null;
        }

        UUID userUid = null;
        UserGroup userGroup = null;
        ProductCategory productCategory = null;
        Long price = null;
        Long quantity = null;

        if ( request.getUserUid() != null ) {
            userUid = UUID.fromString( request.getUserUid() );
        }
        userGroup = request.getUserGroup();
        productCategory = request.getProductCategory();
        price = request.getPrice();
        quantity = request.getQuantity();

        LocalDateTime currentDateTime = java.time.LocalDateTime.now();

        DiscountFilter discountFilter = new DiscountFilter( currentDateTime, userUid, userGroup, productCategory, price, quantity );

        return discountFilter;
    }

    @Override
    public DiscountDto map(DiscountEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DiscountDto.DiscountDtoBuilder discountDto = DiscountDto.builder();

        discountDto.id( entity.getId() );
        discountDto.discountType( entity.getDiscountType() );
        discountDto.discountValue( entity.getDiscountValue() );
        discountDto.orderAmountMin( entity.getOrderAmountMin() );
        discountDto.orderAmountMax( entity.getOrderAmountMax() );
        discountDto.orderQuantity( entity.getOrderQuantity() );
        discountDto.userUid( entity.getUserUid() );
        discountDto.userGroup( entity.getUserGroup() );
        discountDto.productCategory( entity.getProductCategory() );
        discountDto.startDate( entity.getStartDate() );
        discountDto.endDate( entity.getEndDate() );

        return discountDto.build();
    }

    @Override
    public DiscountResponseDto mapDiscountResponse(DiscountRequestDto request, Long discountValue, Long priceAfterDiscount) {
        if ( request == null && discountValue == null && priceAfterDiscount == null ) {
            return null;
        }

        DiscountResponseDto.DiscountResponseDtoBuilder discountResponseDto = DiscountResponseDto.builder();

        if ( request != null ) {
            discountResponseDto.productQuantity( request.getQuantity() );
            discountResponseDto.price( request.getPrice() );
        }
        discountResponseDto.discountValue( discountValue );
        discountResponseDto.priceAfterDiscount( priceAfterDiscount );

        return discountResponseDto.build();
    }
}
