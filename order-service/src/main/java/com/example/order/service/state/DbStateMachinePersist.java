package com.example.order.service.state;

import com.example.domain.enums.OrderEventType;
import com.example.domain.enums.OrderStatus;
import com.example.order.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DbStateMachinePersist
        implements StateMachinePersist<OrderStatus, OrderEventType, OrderDto> {
    private final StateMachineFactory<OrderStatus, OrderEventType> machineFactory;

    @Override
    public void write(final StateMachineContext stateMachineContext, OrderDto dto) throws Exception {

    }

    @Override
    public StateMachineContext<OrderStatus, OrderEventType> read(final OrderDto dto) throws Exception {
        
        return null;
    }

}