package com.example.springexceptionhandling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author manhdt14
 * created in 10/6/2023 8:38 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private Boolean status;
    private String message;
    private HttpStatus httpStatus;
}
