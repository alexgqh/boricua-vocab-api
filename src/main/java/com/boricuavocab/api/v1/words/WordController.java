package com.boricuavocab.api.v1.words;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class WordController {

    private final WordService service;

    public WordController(WordService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/words")
    public List<WordSummary> getWords(
            @RequestParam(name = "difficulty", required = false)
            Integer difficulty
    ) {
        if (difficulty != null) {
            if (difficulty < 1 || difficulty > 4) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Difficulty must be between 1 and 4"
                );
            }
        }

        return service.findWords(difficulty);
    }

    @GetMapping("/api/v1/words/{wordId}")
    public WordSummary getWordById(
            @PathVariable("wordId") long id
    ) {
        return service.findWordById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "No matching word was found"
                    )
                );
    }
}
