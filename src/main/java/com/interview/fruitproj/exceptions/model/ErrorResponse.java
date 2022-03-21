package com.interview.fruitproj.exceptions.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private String code;
    private String description;
    private LocalDateTime timestamp;

    public ErrorResponse(String description, String code) {
        this.code = code;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

}
