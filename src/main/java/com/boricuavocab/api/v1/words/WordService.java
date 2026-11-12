package com.boricuavocab.api.v1.words;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Service;

@Service
public class WordService {

    // Access the repository via dependency injection and Spring / JPA
    private final WordRepository repository;

    public WordService(WordRepository repository) {
        this.repository = repository;
    }

    // Provide the implementation of converting between entities and summaries
    private final Function<WordEntity, WordSummary> entityToSummary =
            wordEntity -> new WordSummary(
                wordEntity.getId(),
                wordEntity.getSpanish(),
                wordEntity.getEnglish(),
                wordEntity.getDifficulty()
            );

    public List<WordSummary> findWords(Integer difficulty) {
        // Get results from repository
        List<WordEntity> entities = (difficulty == null)
                ? repository.findAll()
                : repository.findByDifficulty(difficulty);

        // Convert entities to summaries
        return entities.stream()
                .map(entityToSummary)
                .toList();
    }

    public Optional<WordSummary> findWordById(long id) {
        // Attempt to locate ID
        Optional<WordEntity> entity = repository.findById(id);

        // Convert entity to summary (or return empty optional)
        return entity.map(entityToSummary);
    }
}