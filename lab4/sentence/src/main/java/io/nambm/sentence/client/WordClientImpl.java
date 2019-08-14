package io.nambm.sentence.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class WordClientImpl implements WordClient {

    private final SubjectClient subjectClient;
    private final VerbClient verbClient;
    private final NounClient nounClient;

    public WordClientImpl(SubjectClient subjectClient, VerbClient verbClient, NounClient nounClient) {
        this.subjectClient = subjectClient;
        this.verbClient = verbClient;
        this.nounClient = nounClient;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getDefaultSubject")
    public String getSubject() {
        return subjectClient.getWord();
    }

    @Override
    public String getVerb() {
        return verbClient.getWord();
    }

    @Override
    public String getNoun() {
        return nounClient.getWord();
    }

    public String getDefaultSubject() {
        return "Default Subject";
    }
}