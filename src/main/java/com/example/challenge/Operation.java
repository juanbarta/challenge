package com.example.challenge;

import com.example.challenge.Messages.Messages;

import static com.example.challenge.Messages.Messages.OPERATION_IS_INVALID;
import static com.example.challenge.Messages.Messages.OPERATION_IS_VALID;

public class Operation {
    private double value;
    private Card card;
    public static final double MAX_OPERATION_VALUE = 1000;


    public Operation(Card _card, double _value) {
        setValue(_value);
        setCard(_card);
    }

    private void setValue(double _value) {
        if (_value <= 0) {
            throw new IllegalArgumentException(Messages.VALUE_IS_NULL.label);
        }
        value = _value;
    }

    private void setCard(Card _card) {
        if (_card == null) {
            throw new IllegalArgumentException(Messages.CARD_IS_NULL.label);
        }
        card = _card;
    }

    public Card getCard() {
        return card;
    }

    public double getValue() {
        return value;
    }

    private boolean isValid() {
        return value < MAX_OPERATION_VALUE;
    }

    public String validateOperation() {
        return isValid() ? OPERATION_IS_VALID.label : OPERATION_IS_INVALID.label;
    }

    public String getOperationRate() {
        return "Valor de tasa : $" + calculateOperationRate() + " - Marca de Tarjeta: " + card.getBrandName();
    }

    private double calculateOperationRate() {
        return value * card.getServiceRate();
    }

}
