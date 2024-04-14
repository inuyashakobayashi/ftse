package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
@Id
@Column(name = "customer_id" ,nullable = false)
   private Integer customerId;
}
