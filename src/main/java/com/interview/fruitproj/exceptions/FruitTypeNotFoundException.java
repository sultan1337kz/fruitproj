package com.interview.fruitproj.exceptions;

public class FruitTypeNotFoundException extends RuntimeException {

    public FruitTypeNotFoundException(String message) {
        super(message);
    }

}