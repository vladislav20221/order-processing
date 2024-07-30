package com.example.inventory.entity;

import com.example.domain.entity.AuditTimestamp;
import com.example.domain.enums.ProductCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(updatable = false, nullable = false)
    @EqualsAndHashCode.Include
    private UUID id;
    @Embedded
    private AuditTimestamp timestamp;
    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private String name;
    private String description;
    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer quantity;
    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer soldCount;
    @NotNull
    @Positive
    @Column(nullable = false)
    private Integer price;
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    @NotNull
    @Column(nullable = false)
    private Boolean isBlocked;
}