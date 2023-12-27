package com.workshop.demo.resources.exception;

import com.workshop.demo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(System.currentTimeMillis(),status.value(), "Não encontrado", e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
