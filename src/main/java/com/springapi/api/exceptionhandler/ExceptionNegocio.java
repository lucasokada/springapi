package com.springapi.api.exceptionhandler;

public class ExceptionNegocio extends RuntimeException{

    public ExceptionNegocio(String message) {
        super(message);
    }
}
