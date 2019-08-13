package io.nambm.sentence.repository;

import org.springframework.stereotype.Component;

@Component("subjectRepo")
public class SubjectRepositoryImpl extends WordRepositoryImpl {
    @Override
    public String getPartOfSpeech() {
        return SUBJECT;
    }
}
