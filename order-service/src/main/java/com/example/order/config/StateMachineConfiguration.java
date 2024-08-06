package com.example.order.config;

import com.example.domain.enums.OrderEventType;
import com.example.domain.enums.OrderStatus;
import com.example.order.service.state.LogStateMachineListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Slf4j
@Configuration
@EnableStateMachineFactory(name = "processing-order")
public class StateMachineConfiguration
        extends EnumStateMachineConfigurerAdapter<OrderStatus, OrderEventType> {

    @Override
    public void configure(final StateMachineStateConfigurer<OrderStatus, OrderEventType> states) throws Exception {
        states.withStates()
                .initial(OrderStatus.NEW)
                .end(OrderStatus.COMPLETE)
                .end(OrderStatus.CANCELLED)
                .states(EnumSet.allOf(OrderStatus.class));
    }

    @Override
    public void configure(final StateMachineConfigurationConfigurer<OrderStatus, OrderEventType> config) throws Exception {
        config.withConfiguration()
                .autoStartup(true)
                .listener(new LogStateMachineListener());
    }

    @Override
    public void configure(final StateMachineTransitionConfigurer<OrderStatus, OrderEventType> transitions) throws Exception {
        transitions.withExternal()
                .source(OrderStatus.NEW)
                .target(OrderStatus.PROCESSING)
                .event(OrderEventType.START_PROCESSING)
                .action(
                        (context) -> log.info("handle event: {}", context.getEvent()),
                        (context) -> log.info("handle error event: {} message = [{}]", context.getEvent(), context.getMessage())
                )

                .and()
                .withExternal()
                .source(OrderStatus.PROCESSING)
                .target(OrderStatus.COMPLETE)
                .event(OrderEventType.FINISH_PROCESSING)

                .and()
                .withExternal()
                .source(OrderStatus.PROCESSING)
                .target(OrderStatus.CANCELLED)
                .event(OrderEventType.CANCEL);
    }

}