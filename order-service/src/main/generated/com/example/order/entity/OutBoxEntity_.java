package com.example.order.entity;

import com.example.domain.entity.AuditTimestamp;
import com.example.domain.enums.EventStatus;
import com.example.domain.enums.EventType;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;

@StaticMetamodel(OutBoxEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class OutBoxEntity_ {

	public static final String EVENT_UID = "eventUid";
	public static final String PAYLOAD = "payload";
	public static final String EVENT_STATUS = "eventStatus";
	public static final String ID = "id";
	public static final String EVENT_TYPE = "eventType";
	public static final String TIMESTAMP = "timestamp";

	
	/**
	 * @see com.example.order.entity.OutBoxEntity#eventUid
	 **/
	public static volatile SingularAttribute<OutBoxEntity, UUID> eventUid;
	
	/**
	 * @see com.example.order.entity.OutBoxEntity#payload
	 **/
	public static volatile SingularAttribute<OutBoxEntity, String> payload;
	
	/**
	 * @see com.example.order.entity.OutBoxEntity#eventStatus
	 **/
	public static volatile SingularAttribute<OutBoxEntity, EventStatus> eventStatus;
	
	/**
	 * @see com.example.order.entity.OutBoxEntity#id
	 **/
	public static volatile SingularAttribute<OutBoxEntity, Long> id;
	
	/**
	 * @see com.example.order.entity.OutBoxEntity#eventType
	 **/
	public static volatile SingularAttribute<OutBoxEntity, EventType> eventType;
	
	/**
	 * @see com.example.order.entity.OutBoxEntity
	 **/
	public static volatile EntityType<OutBoxEntity> class_;
	
	/**
	 * @see com.example.order.entity.OutBoxEntity#timestamp
	 **/
	public static volatile SingularAttribute<OutBoxEntity, AuditTimestamp> timestamp;

}

