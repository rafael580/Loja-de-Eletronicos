package com.devsuperior.curso.loja.controllers.exception;

import com.devsuperior.curso.loja.servicies.exception.ResourceNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;


@ControllerAdvice
public class ControllerException {
    @ExceptionHandler(ResourceNotfoundException.class)
    public ResponseEntity<StandError> entityNotFound(ResourceNotfoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandError standError = new StandError();
        standError.setTimestamp(Instant.now());
        standError.setStatus(status.value());
        standError.setError(e.getMessage());
        standError.setMessage("Entity not found");
        standError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(standError);
    }
}
