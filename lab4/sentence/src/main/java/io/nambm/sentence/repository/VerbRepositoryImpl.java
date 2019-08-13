package io.nambm.sentence.repository;

import org.springframework.stereotype.Component;

@Component("verbRepo")
public class VerbRepositoryImpl extends WordRepositoryImpl {
    @Override
    public String getPartOfSpeech() {
        return VERB;
    }
}
