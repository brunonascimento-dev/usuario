package com.nascimentodev.usuario.infrastructure.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensage){
        super(mensage);
    }

    public ResourceNotFoundException(String mensage, Throwable trowable){
        super(mensage, trowable);
    }
}
