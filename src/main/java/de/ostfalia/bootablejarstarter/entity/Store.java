package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id",nullable = false)
    private Integer storeId;
    @JoinColumn(name = "manager_staff_id",nullable = false)
    @ManyToOne
    private Staff manager;
@JoinColumn(name = "address_id",nullable = false)
@OneToOne//hier defeniere ich als one to one weil es 2 eintrage in datenbank
    private Address address;
    @Column(name = "last_update",nullable = false)
    private LocalDateTime lastUpdate;

    @PrePersist
    @PreUpdate
    private void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }

    public Store(Staff manager, Address address, LocalDateTime lastUpdate) {
        this.manager = manager;
        this.address = address;
        this.lastUpdate = lastUpdate;
    }

    public Store() {
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
