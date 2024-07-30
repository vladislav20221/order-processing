package com.example.order.entity;

import com.example.domain.entity.AuditTimestamp;
import com.example.domain.enums.EventStatus;
import com.example.domain.enums.EventType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "out_box")
@EntityListeners(AuditingEntityListener.class)
public class OutBoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID eventUid;
    @Embedded
    private AuditTimestamp timestamp;
    private String payload;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    public OutBoxEntity(EventType eventType) {
        this(eventType, EventStatus.PENDING);
    }

    public OutBoxEntity(EventType eventType, EventStatus eventStatus) {
        this();
        this.eventType = eventType;
        this.eventStatus = eventStatus;
    }

}