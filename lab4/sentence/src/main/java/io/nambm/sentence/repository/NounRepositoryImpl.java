package io.nambm.sentence.repository;

import org.springframework.stereotype.Component;

@Component("nounRepo")
public class NounRepositoryImpl extends WordRepositoryImpl {
    @Override
    public String getPartOfSpeech() {
        return NOUN;
    }
}
