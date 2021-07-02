package com.example.challenge;

import com.example.challenge.BrandStrategy.Amex;
import com.example.challenge.BrandStrategy.Visa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.YearMonth;

@SpringBootApplication
public class ChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
        try {
            final Card amexCard = new Card("456784567", "jose hernandez", YearMonth.of(2021, 7), Amex.getInstance());
            final Card visaCard = new Card("456784567", "jose hernandez", YearMonth.of(2020, 12), Visa.getInstance());
            final Operation visaOperation = new Operation(visaCard, 900);


            System.out.println("*** TARJETA VISA ***");
            System.out.println(visaCard.toString());
            System.out.println(visaCard.getCardValidation());
            System.out.println(visaOperation.validateOperation());
            System.out.println(visaOperation.getOperationRate());
            System.out.println(visaCard.compareCards(amexCard));
        } catch (final RuntimeException e) {
            System.out.println(e.getMessage());
        }


    }
}
