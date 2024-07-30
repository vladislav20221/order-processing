package com.example.order.service.impl;

import com.example.domain.enums.EventStatus;
import com.example.order.entity.OutBoxEntity;
import com.example.order.repository.OutBoxRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@Service
@RequiredArgsConstructor
public class OutBoxProcessor {
    private final OutBoxRepository outBoxRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private OutBoxProcessor outBoxProcessor;

    @Scheduled(initialDelay = 1_000, fixedDelay = 5_000)
    @SchedulerLock(
            name = "OutBoxProcessor_handler",
            lockAtLeastFor = "PT10S",
            lockAtMostFor = "PT1M"
    )
    public void handler() {
        final List<OutBoxEntity> outBoxList =
                outBoxRepository.findAllByEventStatus(EventStatus.PENDING);
        final PriorityQueue<OutBoxEntity> list = new PriorityQueue<>(
                Comparator.comparing(outBox -> outBox.getTimestamp().getCreatedAt())
        );
        list.addAll(outBoxList);

        list.forEach(System.out::println);

        this.outBoxProcessor.updateStatus(outBoxList, EventStatus.PROCESSING);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateStatus(final List<OutBoxEntity> outBoxList, final EventStatus status) {
        outBoxList.forEach(outBox -> outBox.setEventStatus(status));
        this.outBoxRepository.saveAll(outBoxList);
    }

    @Lazy
    @Autowired
    public void setProcessor(final OutBoxProcessor outBoxProcessor) {
        this.outBoxProcessor = outBoxProcessor;
    }

}