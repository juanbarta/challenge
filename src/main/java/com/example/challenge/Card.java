package com.example.challenge;

import com.example.challenge.BrandStrategy.Brand;
import com.example.challenge.Messages.Messages;

import java.time.YearMonth;
import java.util.Objects;

import static com.example.challenge.Messages.Messages.CARD_IS_INVALID;
import static com.example.challenge.Messages.Messages.CARD_IS_VALID;

public class Card {
    private String cardNumber;
    private String cardHolder;
    private YearMonth expirationDate;
    private Brand cardBrand;

    public Card( String _cardNumber,  String _cardHolder,  YearMonth _expirationDate, Brand _cardBrand) {
        setCardHolder(_cardHolder);
        setCardNumber(_cardNumber);
        setExpirationDate(_expirationDate);
        setCardBrand(_cardBrand);
    }

    private void setCardHolder(String _cardHolder) {
        if (_cardHolder == null || _cardHolder.isEmpty()) {
            throw new IllegalArgumentException(Messages.BAD_CARDHOLDER.label);
        }
        cardHolder = _cardHolder;

    }

    private void setCardNumber(String _cardNumber) {
        if (_cardNumber == null || _cardNumber.isEmpty()) {
            throw new IllegalArgumentException(Messages.BAD_CARDNUMBER.label);
        }
        cardNumber = _cardNumber;
    }

    private void setExpirationDate(YearMonth _expirationDate) {
        if (_expirationDate == null) {
            throw new IllegalArgumentException(Messages.BAD_EXPIRATION_DATE.label);
        }
        expirationDate = _expirationDate;
    }

    private void setCardBrand(Brand _cardBrand) {
        if (_cardBrand == null) {
            throw new IllegalArgumentException(Messages.BAD_BRAND.label);
        }
        cardBrand = _cardBrand;
    }

    public double getServiceRate() {
        return cardBrand.getServiceRate();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public Brand getCardBrand() {
        return cardBrand;
    }

    public String getBrandName() {
        return cardBrand.getName();
    }

    @Override
    public String toString() {
        return "Número de Tarjeta: " + cardNumber + " - Titular: " + cardHolder + " - Fecha de Vencimiento: " + expirationDate + " - Marca: " + cardBrand.getName();
    }

    private boolean isValid() {
        return expirationDate.isAfter(YearMonth.now());
    }

    public YearMonth getExpirationDate() {
        return expirationDate;
    }

    public String getCardValidation() {
        return isValid() ? CARD_IS_VALID.label : CARD_IS_INVALID.label;
    }

    @Override
    public boolean equals(Object _card) {
        if (!(_card instanceof Card)) {
            return false;
        }

        final Card card = (Card) _card;
        return (!cardNumber.equals(card.getCardNumber()) || !cardHolder.equals(card.getCardHolder()) || !cardBrand.getName().equals(card.getBrandName()) || !expirationDate.equals(card.getExpirationDate()));
    }

    public String compareCards(Card _card) {
        return equals(_card) ? "La tarjeta " + cardNumber + " es distinta a " + _card.getCardNumber() : "Las tarjetas " + cardNumber + " y " + _card.getCardNumber() + " son iguales";
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardHolder, expirationDate, cardBrand);
    }
}
