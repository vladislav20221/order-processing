package com.example.order.mapper;

import com.example.domain.dto.event.EventOrderProcessingDto;
import com.example.domain.enums.OrderStatus;
import com.example.order.dto.CreateOrderRequest;
import com.example.order.dto.OrderDto;
import com.example.order.entity.OrderEntity;
import com.example.order.entity.OutBoxEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T16:56:02+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderEntity map(CreateOrderRequest request, OrderStatus status) {
        if ( request == null && status == null ) {
            return null;
        }

        OrderEntity.OrderEntityBuilder orderEntity = OrderEntity.builder();

        if ( request != null ) {
            if ( request.getProductUid() != null ) {
                orderEntity.productUid( UUID.fromString( request.getProductUid() ) );
            }
            orderEntity.quantity( request.getQuantity() );
            orderEntity.price( request.getPrice() );
        }
        orderEntity.status( status );

        return orderEntity.build();
    }

    @Override
    public OrderDto map(OrderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        OrderDto.OrderDtoBuilder orderDto = OrderDto.builder();

        orderDto.id( entity.getId() );
        orderDto.productUid( entity.getProductUid() );
        orderDto.quantity( entity.getQuantity() );
        orderDto.price( entity.getPrice() );
        orderDto.status( entity.getStatus() );

        return orderDto.build();
    }

    @Override
    public EventOrderProcessingDto map(OrderEntity order, OutBoxEntity outBox) {
        if ( order == null && outBox == null ) {
            return null;
        }

        EventOrderProcessingDto.EventOrderProcessingDtoBuilder eventOrderProcessingDto = EventOrderProcessingDto.builder();

        if ( order != null ) {
            if ( order.getProductUid() != null ) {
                eventOrderProcessingDto.productUid( order.getProductUid().toString() );
            }
            eventOrderProcessingDto.price( order.getPrice() );
            eventOrderProcessingDto.quantity( order.getQuantity() );
        }
        if ( outBox != null ) {
            if ( outBox.getEventUid() != null ) {
                eventOrderProcessingDto.eventUid( outBox.getEventUid().toString() );
            }
        }

        return eventOrderProcessingDto.build();
    }
}
