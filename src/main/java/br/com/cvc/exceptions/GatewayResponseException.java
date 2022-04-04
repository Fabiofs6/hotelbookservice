package br.com.cvc.exceptions;

public class GatewayResponseException extends RuntimeException{

    public GatewayResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
