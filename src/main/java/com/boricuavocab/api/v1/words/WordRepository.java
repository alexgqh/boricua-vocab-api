package com.boricuavocab.api.v1.words;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository
        extends JpaRepository<WordEntity, Long> {

    List<WordEntity> findByDifficulty(int difficulty);
}