package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id",nullable = false)
    private Integer languageId;

    @Column(length = 20,nullable = false)
    private String name;
    @Column(name = "last_update",nullable = false)
    private LocalDateTime lastUpdate;
    @PrePersist
    @PreUpdate
    private void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }

    public Language() {
    }

    public Language(String name, LocalDateTime lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
