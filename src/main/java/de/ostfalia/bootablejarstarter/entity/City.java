package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;

    @Column(length = 50,nullable = false)
    private String city;

    @JoinColumn(name = "country_id",nullable = false)
    @ManyToOne
    private Country country;

    @Column(name = "last_update",nullable = false)
    private LocalDateTime lastUpdate;
    @PrePersist
    @PreUpdate
    private void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }

    public City() {
    }

    public City(String city, Country country, LocalDateTime lastUpdate) {
        this.city = city;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
