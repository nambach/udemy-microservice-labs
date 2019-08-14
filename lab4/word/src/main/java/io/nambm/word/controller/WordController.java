package io.nambm.word.controller;

import io.nambm.common.domain.Word;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class WordController {
    @Value("${words}")
    private String words;

    @GetMapping("/")
    public String getWord() {
        String[] arr = words.split(",");
        Random random = new Random(System.currentTimeMillis());
        String content = arr[random.nextInt(arr.length)];
        return content;
    }
}
