package com.boricuavocab.api.v1.words;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    private static final List<WordSummary> IN_MEMORY_WORD_LIST = List.of(
            new WordSummary(1, "Janguear", "To hang out", 1),
            new WordSummary(101, "Habichuelas", "Beans", 3),
            new WordSummary(102, "Yierba", "Grass", 2),
            new WordSummary(103, "Verja", "Fence", 2),
            new WordSummary(20930, "Pico", "Pickaxe", 3)
    );

    public List<WordSummary> getWords() {
        return IN_MEMORY_WORD_LIST;
    }
}
