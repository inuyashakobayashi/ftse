package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    private Integer cityId;
}
