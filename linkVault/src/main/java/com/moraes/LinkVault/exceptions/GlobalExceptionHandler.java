package com.moraes.LinkVault.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(LinkNotFoundException.class)
    public ProblemDetail entityNotFoundHandler(LinkNotFoundException e) {

        logger.error("Objeto não encontrato", e);

        ProblemDetail pb = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());

        pb.setTitle("Link não encontrado.");

        pb.setProperty("timestamp", Instant.now());

        return pb;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail methodArgumentNotValid(MethodArgumentNotValidException e) {

        logger.error("Validação não atendida", e);

        ProblemDetail pb = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        pb.setTitle("Dados invalidos.");
        pb.setProperty("timestamp", Instant.now());

        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(f -> f.getField() + ":" + f.getDefaultMessage())
                .toList();

        pb.setProperty("errors", errors);

        return pb;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail genericHandler(Exception e) {
        
        logger.error("Erro desconhecido", e);

        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

        pd.setTitle("Erro desconhecido.");

        pd.setProperty("timestamp", Instant.now());

        return pd;
    }

}
