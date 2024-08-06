package com.example.order.service.impl;

import com.example.domain.dto.event.EventOrderProcessingDto;
import com.example.domain.enums.OrderEventType;
import com.example.order.entity.OutBoxEntity;
import com.example.domain.enums.EventType;
import com.example.domain.enums.OrderStatus;
import com.example.order.repository.OutBoxRepository;
import com.example.order.dto.CreateOrderRequest;
import com.example.order.dto.OrderDto;
import com.example.order.entity.OrderEntity;
import com.example.order.mapper.OrderMapper;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OutBoxRepository outBoxRepository;

    private final StateMachineFactory<OrderStatus, OrderEventType> stateMachineFactory;

    @Override
    public OrderDto create(final CreateOrderRequest request) {
        final UUID eventUid = UUID.randomUUID();
        final OrderEntity order = this.orderMapper.map(request, OrderStatus.NEW);
        final OutBoxEntity outBox = new OutBoxEntity(EventType.NEW_CREATED);
        outBox.setEventUid(eventUid);

        final EventOrderProcessingDto eventOrder = this.orderMapper.map(order, outBox);
        outBox.setPayload(toJson(eventOrder));

        this.orderRepository.save(order);
        this.outBoxRepository.save(outBox);

        return this.orderMapper.map(order);
    }

    @SneakyThrows
    private String toJson(final EventOrderProcessingDto eventOrder) {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String jsonString = objectMapper.writeValueAsString(eventOrder);
        log.debug("creat json event: {}", jsonString);
        return jsonString;
    }

}