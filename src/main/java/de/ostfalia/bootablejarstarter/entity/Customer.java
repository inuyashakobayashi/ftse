package de.ostfalia.bootablejarstarter.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Customer {
    @Id
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @JoinColumn(name = "store_id", nullable = false)
    @ManyToOne
    private Store store;

    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;

    @Column(length = 50)
    private String email;
@JoinColumn(name = "address_id",nullable = false)
@ManyToOne
    private Address address;

@Column(nullable = false,name = "activebool")
    private boolean activeBool =true;


    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "last_update", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastUpdate;
private  Integer active;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActiveBool() {
        return activeBool;
    }

    public void setActiveBool(boolean activeBool) {
        this.activeBool = activeBool;
    }
    @PrePersist
    @PreUpdate
    private void onUpdate() {
        lastUpdate = LocalDateTime.now();
        createDate = LocalDate.now();

    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Customer() {
    }

    public Customer(Store store, String firstName, String lastName, String email, Address address, boolean activeBool, LocalDate createDate, LocalDateTime lastUpdate, Integer active) {
        this.store = store;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.activeBool = activeBool;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.active = active;
    }
}
