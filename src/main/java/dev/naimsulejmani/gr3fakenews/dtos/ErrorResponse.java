package dev.naimsulejmani.gr3fakenews.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String statusMessage;
    private String errorMessage;
    private String path;
    private LocalDateTime timestamp = LocalDateTime.now();
}
