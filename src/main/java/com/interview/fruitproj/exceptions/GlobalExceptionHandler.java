package com.interview.fruitproj.exceptions;

import com.interview.fruitproj.exceptions.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = FruitTypeNotFoundException.class)
    public ResponseEntity<Object> fruitTypeNotFoundException(FruitTypeNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.name()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }


}
