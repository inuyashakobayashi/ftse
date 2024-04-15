package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer rentalId;
}
