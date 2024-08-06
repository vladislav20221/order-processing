package com.example.shopping.cart.entity;

import com.example.domain.entity.AuditTimestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shopping_cart")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private AuditTimestamp timestamp;
    private UUID productUid;
    private UUID orderUid;
    private Long quantity;
    @ManyToOne()
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
}