package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;
    @Column(name = "country",length = 50,nullable = false)
    private String country;
    @Column(name = "last_update",nullable = false)
    private LocalDateTime lastUpdate;
    @PrePersist
    @PreUpdate
    private void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }

    public Country() {
    }

    public Country(String country, LocalDateTime lastUpdate) {
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
