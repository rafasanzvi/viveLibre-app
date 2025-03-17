package com.vivelibre.springboot.app.client;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenProcessor {

    public Map<String, String> processToken(String token) {

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("timestamp", Instant.now().toString());
        return response;
    }
}
