package com.cloudbees.exceptions;

public class PersistenceLayerException extends Exception{
    public PersistenceLayerException(String errorMessage) {
        super(errorMessage);
    }
}
