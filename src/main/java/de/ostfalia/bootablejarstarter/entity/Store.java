package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id",nullable = false)
    private Integer storeId;

}
