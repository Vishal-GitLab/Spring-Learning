package com.demo.first.app.exception;

import com.demo.first.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// ye ak annotation handler hai jo ki intrcept karta hai jo ki exception throw  ho rhe hai by the controller
@RestControllerAdvice           // ye ak spelize annotation hai isko centralized exception define  karne ke liye use kiys jata hai
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);    // GlobalExceptionHandler ka use krke hm exception handling karte hai

     @ExceptionHandler({UserNotFoundException.class, NullPointerException.class})
    // IllegalArgumentException and NullPointerException ye sb ganeric exception hai
    // agr koi bhi  exception aati hai to handle kar dega ye IllegalArgumentException
    public ResponseEntity<Map<String , Object>> handleIllegalArgumentException(Exception exception){    // agar ham multiple exception ko handle kar rhe hai to IllegalArgumentException iska use nhi karenge ham Exception ka use karenge

        logger.error("Error when finding user: ",exception);    // pura jo exception ka object hai hm usko print  kar rhe h

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Bad request");
        errorResponse.put("message", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);   // ye custom error hai    // bad request ko ham IllegalArgumentException ki tarah handle kar rhe hai
    }


    // iska use ham tab karte hai jab hm GET me hai aur kisi dusre me use karna chahte hai jaise put ya  koi bhi ... ye spring boot ki exception hai
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class )
    public ResponseEntity<Map<String , Object>> HttpRequestMethodNotSupportedException(Exception exception){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
        errorResponse.put("error", " Method not allowed on this endpoint");
        errorResponse.put("message", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);   // ye custom error hai    // bad request ko ham IllegalArgumentException ki tarah handle kar rhe hai
    }
}
