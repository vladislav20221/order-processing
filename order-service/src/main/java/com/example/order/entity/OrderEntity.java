package com.example.order.entity;

import com.example.domain.entity.AuditTimestamp;
import com.example.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "order_product")
@EntityListeners(AuditingEntityListener.class)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Embedded
    private AuditTimestamp timestamp;
    private UUID productUid;
    private Integer quantity;
    private Integer price;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}