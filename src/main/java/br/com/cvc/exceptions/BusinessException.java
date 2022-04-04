package br.com.cvc.exceptions;

public class BusinessException extends RuntimeException{

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
