package com.stackroute.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exception3(Exception e) {
        return new ResponseEntity<>("Internal Server Error", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Object> exception1(MovieAlreadyExistsException exception, WebRequest request){
        return new ResponseEntity<>("Movie already Exists", HttpStatus.NOT_MODIFIED);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Object> exception2(MovieNotFoundException exception){

        return new ResponseEntity<>("Movie Not Found",HttpStatus.NOT_FOUND);
    }
}
