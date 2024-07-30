package com.example.discount.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DiscountFlags.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class DiscountFlags_ {

	public static final String IS_ALL_CATEGORY = "isAllCategory";
	public static final String IS_ALL_USERS = "isAllUsers";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_ALL_GROUP = "isAllGroup";

	
	/**
	 * @see com.example.discount.entity.DiscountFlags#isAllCategory
	 **/
	public static volatile SingularAttribute<DiscountFlags, Boolean> isAllCategory;
	
	/**
	 * @see com.example.discount.entity.DiscountFlags#isAllUsers
	 **/
	public static volatile SingularAttribute<DiscountFlags, Boolean> isAllUsers;
	
	/**
	 * @see com.example.discount.entity.DiscountFlags#isActive
	 **/
	public static volatile SingularAttribute<DiscountFlags, Boolean> isActive;
	
	/**
	 * @see com.example.discount.entity.DiscountFlags#isAllGroup
	 **/
	public static volatile SingularAttribute<DiscountFlags, Boolean> isAllGroup;
	
	/**
	 * @see com.example.discount.entity.DiscountFlags
	 **/
	public static volatile EmbeddableType<DiscountFlags> class_;

}

