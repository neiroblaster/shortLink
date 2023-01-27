package com.shchayuk.test.shortLink.controllers;

import com.shchayuk.test.shortLink.models.Link;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class LinkControllerTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getShortLink_createShortLink_getTheSameResultFromResponse() {
        String original = "http://localhost:8080/test";
        String PREDICATE = "/li/";

        Link link = new Link();
        link.setOriginal(original);
        String shortLink = PREDICATE + link.hashCode();

        Map<String, String> map = new HashMap<>();
        map.put("original", original);

        String url = format("http://localhost:8080/generate", port);

        ResponseEntity<Map> response = restTemplate.postForEntity(url, map, Map.class);
        String responseToCheck = response.getBody().get("short").toString();
        assertThat(responseToCheck).isEqualTo(shortLink);
    }
}