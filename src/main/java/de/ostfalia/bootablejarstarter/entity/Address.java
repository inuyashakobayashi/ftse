package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id",nullable = false)

    private  Integer addressId;
@Column(name = "address" ,length = 50,nullable = false)

    private String address;
    @Column(name = "address2" ,length = 50)

private String address2;

    @NotNull
    @Column(name = "district",length = 20,nullable = false)
    private String district;

    @NotNull
    @JoinColumn(name = "city_id",nullable = false)
    @ManyToOne
    private City city;
    @Column(name = "postal_code",length = 10)
    private String postalCode;
    @Column(name = "phone",length = 20,nullable = false)
    private String phone;

    @Column(name = "last_update",nullable = false)
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "address")
    private List<Customer> customers;//map relationship um besser zu handle delete und update cascade operation
    @PrePersist
    @PreUpdate
    private void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }

    public Address() {
    }

    public Address(String address, String address2, String district, City city, String postalCode, String phone, LocalDateTime lastUpdate, List<Customer> customers) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
        this.customers = customers;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
