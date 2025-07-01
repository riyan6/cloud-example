package org.github.riyan6.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/name")
    String userName() {
        return "UserName:" + System.currentTimeMillis();
    }

    @GetMapping("/call/players")
    String callUser() {
        String playersServiceUrl = "http://players-service:3020/api/players/name";
        return restTemplate.getForObject(playersServiceUrl, String.class);
    }

}
