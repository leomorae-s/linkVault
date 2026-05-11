package com.moraes.LinkVault.exceptions;

import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> genericHandler(Exception e) {
        
        logger.error("Erro desconhecido", e);

        return ResponseEntity.status(500).body("Erro desconhecido");
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundHandler(EntityNotFoundException e) {

        logger.error("Objeto não encontrato", e);

        return ResponseEntity.status(404).body("Recurso não encontrado");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValid(MethodArgumentNotValidException e) {

        logger.error("Validação não atendida", e);

        return ResponseEntity.status(400).body("Dados inseridos não atendem a validação");
    }
}
