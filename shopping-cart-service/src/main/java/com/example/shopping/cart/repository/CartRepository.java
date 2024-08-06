package com.example.shopping.cart.repository;

import com.example.shopping.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

    Optional<CartEntity> findByUserUid(UUID userUid);

    void deleteByUserUid(UUID userUid);

}