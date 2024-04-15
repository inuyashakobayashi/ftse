package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id",nullable = false)
    private Integer rentalId;
    @Column(name = "rental_date",nullable = false)
    private LocalDateTime rentalDate;
   @JoinColumn(name = "inventory_id",nullable = false)
@ManyToOne
    private Inventory inventory;
}
