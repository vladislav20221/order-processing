package com.example.discount.repository;

import com.example.discount.entity.DiscountEntity;
import com.example.discount.model.DiscountFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity, Long> {

    @Query(value = "select dis from DiscountEntity as dis where " +
            ":#{#filter.currentDateTime()} between dis.startDate and dis.endDate and " +
            ":#{#filter.price()} between dis.orderAmountMin and dis.orderAmountMax and " +
            ":#{#filter.quantity()} >= dis.orderQuantity and " +
            "(:#{#filter.userUid()} = dis.userUid or dis.flags.isAllUsers) and " +
            "(:#{#filter.userGroup()} = dis.userGroup or dis.flags.isAllGroup) and " +
            "(:#{#filter.productCategory()} = dis.productCategory or dis.flags.isAllCategory) and " +
            "dis.flags.isActive")
    List<DiscountEntity> findFilters(@Param("filter") final DiscountFilter filter);

}