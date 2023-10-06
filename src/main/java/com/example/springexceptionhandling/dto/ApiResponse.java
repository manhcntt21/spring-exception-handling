package com.example.springexceptionhandling.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Api Response for deleting")
public class ApiResponse {
    @Schema(description = "status true or false, true is success, and false is fail")
    private Boolean status;
    @Schema(description = "message error")
    private String message;
    @Schema(description = "http status code")
    private HttpStatus httpStatus;
}
