package io.nambm.sentence.repository;

import io.nambm.sentence.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

public abstract class WordRepositoryImpl implements WordRepository {

    @Autowired
    LoadBalancerClient loadBalancer;

    public abstract String getPartOfSpeech();

    public Word getWord() {
        ServiceInstance instance = loadBalancer.choose(getPartOfSpeech());
        String content = (new RestTemplate()).getForObject(instance.getUri(), String.class);
        return new Word(content);
    }
}
