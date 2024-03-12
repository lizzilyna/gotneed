package it.epicode.gotneed.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private LocalDateTime dataerror;

    public ErrorResponse(String message) {
        this.message = message;
        dataerror = LocalDateTime.now();
    }
}
