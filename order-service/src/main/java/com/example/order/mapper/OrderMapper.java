package com.example.order.mapper;

import com.example.domain.dto.event.EventOrderProcessingDto;
import com.example.domain.enums.OrderStatus;
import com.example.order.entity.OutBoxEntity;
import com.example.order.dto.CreateOrderRequest;
import com.example.order.dto.OrderDto;
import com.example.order.entity.OrderEntity;
import org.mapstruct.*;

import java.util.SimpleTimeZone;
import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface OrderMapper {

    OrderEntity map(CreateOrderRequest request, OrderStatus status);

    OrderDto map(OrderEntity entity);

    EventOrderProcessingDto map(OrderEntity order, OutBoxEntity outBox);

}