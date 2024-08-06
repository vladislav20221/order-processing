package com.example.order.entity;

import com.example.domain.entity.AuditTimestamp;
import com.example.domain.enums.OrderStatus;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

@StaticMetamodel(OrderEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class OrderEntity_ {

	public static final String QUANTITY = "quantity";
	public static final String PRICE = "price";
	public static final String ID = "id";
	public static final String PRODUCT_UID = "productUid";
	public static final String TIMESTAMP = "timestamp";
	public static final String STATUS = "status";

	
	/**
	 * @see com.example.order.entity.OrderEntity#quantity
	 **/
	public static volatile SingularAttribute<OrderEntity, Integer> quantity;
	
	/**
	 * @see com.example.order.entity.OrderEntity#price
	 **/
	public static volatile SingularAttribute<OrderEntity, Integer> price;
	
	/**
	 * @see com.example.order.entity.OrderEntity#id
	 **/
	public static volatile SingularAttribute<OrderEntity, UUID> id;
	
	/**
	 * @see com.example.order.entity.OrderEntity
	 **/
	public static volatile EntityType<OrderEntity> class_;
	
	/**
	 * @see com.example.order.entity.OrderEntity#productUid
	 **/
	public static volatile SingularAttribute<OrderEntity, UUID> productUid;
	
	/**
	 * @see com.example.order.entity.OrderEntity#timestamp
	 **/
	public static volatile SingularAttribute<OrderEntity, AuditTimestamp> timestamp;
	
	/**
	 * @see com.example.order.entity.OrderEntity#status
	 **/
	public static volatile SingularAttribute<OrderEntity, OrderStatus> status;

}

