package org.github.riyan6.player;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final RestTemplate restTemplate;

    public PlayerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/name")
    String name() {
        return "playerName:" + System.currentTimeMillis();
    }

    @GetMapping("/call/users")
    String callUser() {
        String usersServiceUrl = "http://users-service:3010/api/users/name";
        return restTemplate.getForObject(usersServiceUrl, String.class);
    }

}
