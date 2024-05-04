
package com.guizKev.api.exeptions;

public class NotFoundEndPoint extends RuntimeException {
    
    public NotFoundEndPoint(String message){
        super(message);
    }
}