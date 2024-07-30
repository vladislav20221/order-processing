package com.example.order.repository;

import com.example.domain.enums.EventStatus;
import com.example.order.entity.OutBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutBoxRepository extends JpaRepository<OutBoxEntity, Long> {

    List<OutBoxEntity> findAllByEventStatus(EventStatus status);

}