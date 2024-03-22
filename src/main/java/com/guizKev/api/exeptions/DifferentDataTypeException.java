package com.guizKev.api.exeptions;

public class DifferentDataTypeException extends RuntimeException {
    
    public DifferentDataTypeException(String message){
        super(message);
    }
}
