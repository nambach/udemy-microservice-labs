package io.nambm.sentence.service;

import io.nambm.sentence.repository.WordRepository;
import org.springframework.stereotype.Service;

//@Service
public class SentenceServiceImpl implements SentenceService {

    final WordRepository subjectRepo;
    final WordRepository verbRepo;
    final WordRepository nounRepo;

    public SentenceServiceImpl(WordRepository subjectRepo,
                               WordRepository verbRepo,
                               WordRepository nounRepo) {
        this.subjectRepo = subjectRepo;
        this.verbRepo = verbRepo;
        this.nounRepo = nounRepo;
    }

    @Override
    public String buildSentence() {
        return String.format("%s %s %s.", subjectRepo.getWord(), verbRepo.getWord(), nounRepo.getWord());
    }
}
