package com.example.discount.entity;

import com.example.discount.enums.DiscountType;
import com.example.domain.entity.AuditTimestamp;
import com.example.domain.enums.ProductCategory;
import com.example.domain.enums.UserGroup;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import java.util.UUID;

@StaticMetamodel(DiscountEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class DiscountEntity_ {

	public static final String END_DATE = "endDate";
	public static final String FLAGS = "flags";
	public static final String ORDER_AMOUNT_MAX = "orderAmountMax";
	public static final String ORDER_QUANTITY = "orderQuantity";
	public static final String PRODUCT_CATEGORY = "productCategory";
	public static final String ORDER_AMOUNT_MIN = "orderAmountMin";
	public static final String DISCOUNT_TYPE = "discountType";
	public static final String ID = "id";
	public static final String DISCOUNT_VALUE = "discountValue";
	public static final String USER_GROUP = "userGroup";
	public static final String START_DATE = "startDate";
	public static final String TIMESTAMP = "timestamp";
	public static final String USER_UID = "userUid";

	
	/**
	 * @see com.example.discount.entity.DiscountEntity#endDate
	 **/
	public static volatile SingularAttribute<DiscountEntity, LocalDateTime> endDate;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#flags
	 **/
	public static volatile SingularAttribute<DiscountEntity, DiscountFlags> flags;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#orderAmountMax
	 **/
	public static volatile SingularAttribute<DiscountEntity, Long> orderAmountMax;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#orderQuantity
	 **/
	public static volatile SingularAttribute<DiscountEntity, Long> orderQuantity;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#productCategory
	 **/
	public static volatile SingularAttribute<DiscountEntity, ProductCategory> productCategory;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#orderAmountMin
	 **/
	public static volatile SingularAttribute<DiscountEntity, Long> orderAmountMin;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#discountType
	 **/
	public static volatile SingularAttribute<DiscountEntity, DiscountType> discountType;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#id
	 **/
	public static volatile SingularAttribute<DiscountEntity, Long> id;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity
	 **/
	public static volatile EntityType<DiscountEntity> class_;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#discountValue
	 **/
	public static volatile SingularAttribute<DiscountEntity, Long> discountValue;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#userGroup
	 **/
	public static volatile SingularAttribute<DiscountEntity, UserGroup> userGroup;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#startDate
	 **/
	public static volatile SingularAttribute<DiscountEntity, LocalDateTime> startDate;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#timestamp
	 **/
	public static volatile SingularAttribute<DiscountEntity, AuditTimestamp> timestamp;
	
	/**
	 * @see com.example.discount.entity.DiscountEntity#userUid
	 **/
	public static volatile SingularAttribute<DiscountEntity, UUID> userUid;

}

