package com.example.challenge.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseGenerator {

    private ResponseGenerator() {
    }

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Double result) {
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("rate", result);
        map.put("message", message);
        map.put("status", status);
        map.put("statusValue", status.value());

        return new ResponseEntity<Object>(map, status);
    }
}
