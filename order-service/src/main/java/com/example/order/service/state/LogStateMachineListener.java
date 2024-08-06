package com.example.order.service.state;

import com.example.domain.enums.OrderEventType;
import com.example.domain.enums.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

@Slf4j
public class LogStateMachineListener extends StateMachineListenerAdapter<OrderStatus, OrderEventType> {

    @Override
    public void stateChanged(
            final State<OrderStatus, OrderEventType> from,
            final State<OrderStatus, OrderEventType> to
    ) {
        super.stateChanged(from, to);
        log.info("change state: to {} form {}", to.getId(), from.getId());
    }

}