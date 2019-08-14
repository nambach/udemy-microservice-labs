package io.nambm.sentence.client;

import io.nambm.common.domain.Word;
import io.nambm.sentence.repository.WordRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(WordRepository.VERB)
public interface VerbClient {

    @GetMapping("/")
    String getWord();
}
