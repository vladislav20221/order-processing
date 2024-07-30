package com.example.discount.entity;

import com.example.domain.entity.AuditTimestamp;
import com.example.discount.enums.DiscountType;
import com.example.domain.enums.ProductCategory;
import com.example.domain.enums.UserGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@ToString
@Table(name = "discount")
@Entity
public class DiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private AuditTimestamp timestamp;
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
    private Long discountValue;
    private Long orderAmountMin;
    private Long orderAmountMax;
    private Long orderQuantity;
    @org.hibernate.validator.constraints.UUID
    private UUID userUid;
    @Enumerated(EnumType.STRING)
    private UserGroup userGroup;
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Embedded
    private DiscountFlags flags;
}