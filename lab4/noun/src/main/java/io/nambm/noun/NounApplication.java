package io.nambm.noun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class NounApplication {

	public static void main(String[] args) {
		SpringApplication.run(NounApplication.class, args);
	}

}

@RestController
class Controller {
	@Value("${words}")
	private String words;

	@GetMapping("/")
	public String getWord() {
		String[] arr = words.split(",");
		int i = (int) Math.round(Math.random() * (arr.length - 1));
		return arr[i];
	}
}