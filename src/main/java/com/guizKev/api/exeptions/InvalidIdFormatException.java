package com.guizKev.api.exeptions;

public class InvalidIdFormatException extends RuntimeException {
    
    public InvalidIdFormatException(String message){
        super(message);
    }
}