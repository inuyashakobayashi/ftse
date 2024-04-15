package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id",nullable = false)
    private Integer staffId;
    @Column(name = "first_name",nullable = false,length = 45)
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 45)
    private String lastName;

    @JoinColumn(name = "address_id",nullable = false)
    @ManyToOne
    private Address address;

    @Column(length = 50)
    private String email;

    @JoinColumn(name = "store_id",nullable = false)
    @ManyToOne
    private Store store;

    @Column(nullable = false)
    private boolean active;//default true

    @Column(length = 16, nullable = false,name = "username")
    private String userName;

    @Column(length = 40)
    private String password;

    private byte picture;
    @Column(name = "last_update",nullable = false)
    private LocalDateTime lastUpdate;
    @PrePersist
    @PreUpdate
    private void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }

    public Staff(String firstName, String lastName, Address address, String email, Store store, boolean active, String userName, String password, byte picture, LocalDateTime lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.store = store;
        this.active = active;
        this.userName = userName;
        this.password = password;
        this.picture = picture;
        this.lastUpdate = lastUpdate;
    }

    public Staff() {
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getPicture() {
        return picture;
    }

    public void setPicture(byte picture) {
        this.picture = picture;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
