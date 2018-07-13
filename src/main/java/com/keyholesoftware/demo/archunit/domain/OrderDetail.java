package com.keyholesoftware.demo.archunit.domain;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;



@Embeddable
@Entity
@Table(name = "OrderDetails", schema="northwind")
public class OrderDetail extends DomainObject {
    
    Long orderId;
    Long productId;
    Double quantity; //DEFAULT '0.0000',
    Double unitPrice; //DEFAULT '0.0000',
    Integer discount; //DEFAULT '0',
    String orderDetailStatus;
    Date dateAllocated;
    
   
}
