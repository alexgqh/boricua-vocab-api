package com.boricuavocab.api.v1.words;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

    private final WordService service;

    public WordController(WordService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/words")
    public List<WordSummary> getWords() {
        return service.getWords();
    }
}
