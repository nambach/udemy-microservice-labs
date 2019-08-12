package io.nambm.word.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class SentenceController {
//    private final
//    DiscoveryClient client;
//
//    public SentenceController(DiscoveryClient client) {
//        this.client = client;
//    }
//
//    private String getWord(String service) {
//        List<ServiceInstance> list = client.getInstances(service);
//        if (!CollectionUtils.isEmpty(list)) {
//            URI uri = list.get(0).getUri();
//            if (uri != null) {
//                return (new RestTemplate()).getForObject(uri, String.class);
//            }
//        }
//
//        return null;
//    }

    @Autowired
    RestTemplate template;

    private String getWord(String service) {
        return template.getForObject("http://" + service, String.class);
    }

    @GetMapping("/sentence")
    public String getSentence() {
        return getWord("SUBJECT") + " "
                + getWord("VERB") + " "
                + getWord("NOUN") + ".";
    }
}
