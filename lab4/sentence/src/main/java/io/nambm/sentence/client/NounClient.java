package io.nambm.sentence.client;

import io.nambm.sentence.model.Word;
import io.nambm.sentence.repository.WordRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(WordRepository.NOUN)
public interface NounClient {

    @GetMapping("/")
    Word getWord();
}
