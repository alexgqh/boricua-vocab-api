package com.boricuavocab.api.v1.words;

public record WordSummary(
        long id,
        String spanish,
        String english,
        int difficulty
) {}