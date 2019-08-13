package io.nambm.sentence.repository;

import io.nambm.sentence.domain.Word;

public interface WordRepository {
    static final String SUBJECT = "SUBJECT";
    static final String VERB = "VERB";
    static final String NOUN = "NOUN";

    Word getWord();
}
