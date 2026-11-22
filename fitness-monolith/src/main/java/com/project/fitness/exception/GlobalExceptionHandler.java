package com.project.fitness.exception;

// iski help se ham exception handler karenge

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>       handleValidationErrors(MethodArgumentNotValidException ex ) {              // map ka use isliye kar rhe hai taki sab data isme store ho sake
      Map<String,String> errors = new HashMap<>();
      ex.getBindingResult().getFieldErrors()
              .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

      return ResponseEntity.badRequest().body(errors);
    }
    }
























