package com.project.forum.response;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
@Valid
public class ApiResponse {
    private HttpStatus statusCode = HttpStatus.BAD_REQUEST;
    private boolean success = false;
    private Object data = null;
    private String service = "Feature Has input exception";
    private String message = "";
}
