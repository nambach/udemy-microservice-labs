package io.nambm.sentence.service;

import io.nambm.sentence.client.WordClient;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl2 implements SentenceService {

    private final WordClient wordClient;

    public SentenceServiceImpl2(WordClient wordClient) {
        this.wordClient = wordClient;
    }

    @Override
    public String buildSentence() {
        return String.format("%s %s %s.", wordClient.getSubject(), wordClient.getVerb(), wordClient.getNoun());
    }
}
