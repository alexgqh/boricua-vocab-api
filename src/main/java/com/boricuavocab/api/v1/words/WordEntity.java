package com.boricuavocab.api.v1.words;

import jakarta.persistence.*;

@Entity
@Table(name = "words")
public class WordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String spanish;

    @Column(nullable = false)
    private String english;

    @Column(nullable = false)
    private int difficulty;

    protected WordEntity() {}

    public Long getId() { return id; }
    public String getSpanish() { return spanish; }
    public String getEnglish() { return english; }
    public int getDifficulty() { return difficulty; }
}