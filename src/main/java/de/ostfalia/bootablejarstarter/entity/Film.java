package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id",nullable = false)
    private Integer filmId;
    @Column(nullable = false)
    private String title;
    private String description;


@Column(name = "release_year")
    private Short releaseYear;

@JoinColumn(nullable = false,name = "language_id")
@ManyToOne
    private Language language;

@Column(name = "rental_duration",nullable = false)
    private Short rentalDuration = 3;

@Column(name = "rental_rate",nullable = false,precision = 4,scale = 2)
    private BigDecimal rentalRate ;

private Short length;
@Column(name = "replacement_cost",nullable = false,precision = 5,scale = 2)
private BigDecimal replacementCost;

@Column(length = 5)
private String rating;
    @Column(name = "last_update",nullable = false)
    private LocalDateTime lastUpdate;
    @PreUpdate
    private void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }


    @PrePersist
    public void prePersist() {
        if (rentalRate == null) {
            rentalRate = BigDecimal.valueOf(4.99);
        }
        if (replacementCost == null) {
            replacementCost = BigDecimal.valueOf(19.99);
        }

        lastUpdate = LocalDateTime.now();
    }
}
