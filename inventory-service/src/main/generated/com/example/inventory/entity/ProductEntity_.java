package com.example.inventory.entity;

import com.example.domain.entity.AuditTimestamp;
import com.example.domain.enums.ProductCategory;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

@StaticMetamodel(ProductEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class ProductEntity_ {

	public static final String SOLD_COUNT = "soldCount";
	public static final String QUANTITY = "quantity";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String IS_BLOCKED = "isBlocked";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String TIMESTAMP = "timestamp";

	
	/**
	 * @see com.example.inventory.entity.ProductEntity#soldCount
	 **/
	public static volatile SingularAttribute<ProductEntity, Integer> soldCount;
	
	/**
	 * @see com.example.inventory.entity.ProductEntity#quantity
	 **/
	public static volatile SingularAttribute<ProductEntity, Integer> quantity;
	
	/**
	 * @see com.example.inventory.entity.ProductEntity#price
	 **/
	public static volatile SingularAttribute<ProductEntity, Integer> price;
	
	/**
	 * @see com.example.inventory.entity.ProductEntity#name
	 **/
	public static volatile SingularAttribute<ProductEntity, String> name;
	
	/**
	 * @see com.example.inventory.entity.ProductEntity#isBlocked
	 **/
	public static volatile SingularAttribute<ProductEntity, Boolean> isBlocked;
	
	/**
	 * @see com.example.inventory.entity.ProductEntity#description
	 **/
	public static volatile SingularAttribute<ProductEntity, String> description;
	
	/**
	 * @see com.example.inventory.entity.ProductEntity#id
	 **/
	public static volatile SingularAttribute<ProductEntity, UUID> id;
	
	/**
	 * @see com.example.inventory.entity.ProductEntity#category
	 **/
	public static volatile SingularAttribute<ProductEntity, ProductCategory> category;
	
	/**
	 * @see com.example.inventory.entity.ProductEntity
	 **/
	public static volatile EntityType<ProductEntity> class_;
	
	/**
	 * @see com.example.inventory.entity.ProductEntity#timestamp
	 **/
	public static volatile SingularAttribute<ProductEntity, AuditTimestamp> timestamp;

}

