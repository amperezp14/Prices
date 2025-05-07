package com.inditex.prices.application.exception;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException() {
        super("No se encontró un precio aplicable para los parámetros dados.");
    }

    public PriceNotFoundException(String message) {
        super(message);
    }

    public PriceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}