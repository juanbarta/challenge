package com.example.challenge.Service;

import com.example.challenge.BrandStrategy.Amex;
import com.example.challenge.BrandStrategy.Brand;
import com.example.challenge.BrandStrategy.Nara;
import com.example.challenge.BrandStrategy.Visa;
import com.example.challenge.Messages.Messages;
import com.example.challenge.Operation;

import static com.example.challenge.Messages.Messages.INVALID_CARDBRAND;

public class RateResponse {
    private final String cardBrand;
    private final double value;

    public RateResponse(String _cardBrand, double _value) {
        cardBrand = _cardBrand;
        value = _value;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public double getValue() {
        return value;
    }

    private Brand setBrand() {
        switch (cardBrand.toLowerCase()) {
            case "visa":
                return Visa.getInstance();
            case "nara":
                return Nara.getInstance();
            case "amex":
                return Amex.getInstance();
            default:
                throw new IllegalArgumentException(INVALID_CARDBRAND.label);
        }
    }

    public double calculateOperationRate() {
        if (value > Operation.MAX_OPERATION_VALUE) {
            throw new IllegalArgumentException(Messages.OPERATION_IS_INVALID.label);
        }
        return value * setBrand().getServiceRate();
    }
}
