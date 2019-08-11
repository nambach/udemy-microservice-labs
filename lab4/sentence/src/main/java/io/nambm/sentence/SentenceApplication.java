package io.nambm.sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class SentenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentenceApplication.class, args);
	}

}

@RestController
class Controller {
	private final
	DiscoveryClient client;

	public Controller(DiscoveryClient client) {
		this.client = client;
	}

	private String getWord(String service) {
		List<ServiceInstance> list = client.getInstances(service);
		if (!CollectionUtils.isEmpty(list)) {
			URI uri = list.get(0).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}

		return null;
	}

	@GetMapping("/sentence")
	public String getSentence() {
		return getWord("SUBJECT") + " "
				+ getWord("VERB") + " "
				+ getWord("NOUN") + ".";
	}
}
