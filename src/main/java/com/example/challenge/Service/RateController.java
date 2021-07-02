package com.example.challenge.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.challenge.Messages.Messages.API_SUCCESS;

@RestController
@RequestMapping(value = "api/operations", produces = "application/JSON", consumes = "application/JSON")
public class RateController {

    @GetMapping("/calculateRate")
    public ResponseEntity<Object> getRate(@RequestBody RateResponse rateResponse) {
        try {
            final double result = Math.round(rateResponse.calculateOperationRate());
            return ResponseGenerator.generateResponse(API_SUCCESS.label, HttpStatus.OK, result);
        } catch (final IllegalArgumentException e) {
            return ResponseGenerator.generateResponse(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }
}
