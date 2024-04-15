package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id",nullable = false)
    private Integer paymentId;

    @JoinColumn(name = "customer_id",nullable = false)
    @ManyToOne
    private Customer customer;
    @JoinColumn(name = "staff_id",nullable = false)
    @ManyToOne
    private Staff staff;

    @JoinColumn(name = "rental_id",nullable = false)
@ManyToOne
    private Rental rental;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(name = "payment_date",nullable = false)
    private LocalDateTime paymentDate;

    public Payment(Customer customer, Staff staff, Rental rental, BigDecimal amount, LocalDateTime paymentDate) {
        this.customer = customer;
        this.staff = staff;
        this.rental = rental;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Payment() {
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}

