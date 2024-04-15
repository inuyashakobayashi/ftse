package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id",nullable = false)
    private Integer inventoryId;

    @JoinColumn(name = "film_id",nullable = false)
    @ManyToOne
    private Film film;

    @JoinColumn(name = "store_id",nullable = false)
    @ManyToOne
    private Store store;
    @Column(name = "last_update",nullable = false)
    private LocalDateTime lastUpdate;
    @PrePersist
    @PreUpdate
    private void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }

    public Inventory() {
    }

    public Inventory(Film film, Store store, LocalDateTime lastUpdate) {
        this.film = film;
        this.store = store;
        this.lastUpdate = lastUpdate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
