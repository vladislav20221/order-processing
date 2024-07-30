package com.example.discount.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Embeddable
@AllArgsConstructor(staticName = "of")
public class DiscountFlags {
    private Boolean isActive;
    private Boolean isAllUsers;
    private Boolean isAllGroup;
    private Boolean isAllCategory;
}