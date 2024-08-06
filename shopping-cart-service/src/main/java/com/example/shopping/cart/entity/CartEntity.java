package com.example.shopping.cart.entity;

import com.example.domain.entity.AuditTimestamp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_cart")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID userUid;
    @Embedded
    private AuditTimestamp timestamp;
    private Boolean isBlocked;
    @OneToMany(mappedBy = "cart")
    private List<CartItemEntity> carts;
}