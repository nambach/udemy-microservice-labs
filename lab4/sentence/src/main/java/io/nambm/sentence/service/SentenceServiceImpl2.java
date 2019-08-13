package io.nambm.sentence.service;

import io.nambm.sentence.client.NounClient;
import io.nambm.sentence.client.SubjectClient;
import io.nambm.sentence.client.VerbClient;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl2 implements SentenceService {

    private final SubjectClient subjectClient;
    private final VerbClient verbClient;
    private final NounClient nounClient;

    public SentenceServiceImpl2(SubjectClient subjectClient,
                                VerbClient verbClient,
                                NounClient nounClient) {
        this.subjectClient = subjectClient;
        this.verbClient = verbClient;
        this.nounClient = nounClient;
    }

    @Override
    public String buildSentence() {
        return String.format("%s %s %s.", subjectClient.getWord(), verbClient.getWord(), nounClient.getWord());
    }
}
