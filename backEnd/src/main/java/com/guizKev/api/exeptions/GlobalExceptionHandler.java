package com.guizKev.api.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("No se encontró el recurso solicitado", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundEndPoint.class)
    public ResponseEntity<Object> handleEndpointNotFoundException(NotFoundEndPoint ex) {
        ErrorResponses errorResponse = new ErrorResponses("El endpoint solicitado no está definido en la API", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

  
}