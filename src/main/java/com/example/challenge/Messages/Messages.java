package com.example.challenge.Messages;

public enum Messages {
    BAD_CARDNUMBER("El número de la tarjeta no puede estar vacío"),
    BAD_CARDHOLDER("El Titular de la tarjeta no puede estar vacío"),
    BAD_BRAND("La marca de la tarjeta no puede estar vacía"),
    BAD_EXPIRATION_DATE("La fecha de vencimiento no puede estar vacía"),
    VALUE_IS_NULL("El valor de la operación no puede ser cero ni negativo"),
    CARD_IS_NULL("La tarjeta de la operación no puede ser nula"),
    API_SUCCESS("La tasa se calculó con éxito!"),
    INVALID_CARDBRAND("La marca no existe"),
    CARD_IS_VALID("La tarjeta es válida para operar"),
    CARD_IS_INVALID("La tarjeta no es válida para operar"),
    OPERATION_IS_VALID("La operación es válida"),
    OPERATION_IS_INVALID("La operación no es válida (el valor debe ser menor a 1000)");

    public final String label;

    Messages(String s) {
        label = s;
    }
}
