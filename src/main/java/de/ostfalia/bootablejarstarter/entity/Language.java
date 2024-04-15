package de.ostfalia.bootablejarstarter.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id",nullable = false)
    private Integer languageId;

}
