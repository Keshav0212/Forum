package com.project.forum.advice;
import com.project.forum.exceptions.*;
import com.project.forum.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ApiResponse> handleUserServiceException(UserServiceException exception){
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setStatusCode(HttpStatus.valueOf(HttpStatus.BAD_REQUEST.value()));
        apiResponse.setData(null);
        apiResponse.setSuccess(false);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setService("APPUSER-" + HttpStatus.BAD_REQUEST.value());
        log.info("jaggu's code");

        return ResponseEntity.badRequest().body(apiResponse);

    }

}
