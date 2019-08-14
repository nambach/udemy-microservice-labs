package io.nambm.sentence.client;

import io.nambm.sentence.model.Word;
import io.nambm.sentence.repository.WordRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(WordRepository.SUBJECT)
public interface SubjectClient {

    @GetMapping("/")
    Word getWord();
}
