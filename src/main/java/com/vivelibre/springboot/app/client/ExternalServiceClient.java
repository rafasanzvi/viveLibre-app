package com.vivelibre.springboot.app.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExternalServiceClient {

    public String getToken() {

        String urlToken = "http://localhost:8080/token";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> bodyCredentials = new HashMap<>();
        bodyCredentials.put("username", "auth-vivelibre");
        bodyCredentials.put("password", "password");

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(bodyCredentials, headers);
        Map<String, String> response = restTemplate.postForObject(urlToken, entity, Map.class);

        if(response != null) {
            return response.get("token");
        }
        throw new RuntimeException("it was not able to get token");
    }
}
