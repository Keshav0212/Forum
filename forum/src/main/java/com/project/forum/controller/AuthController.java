package com.project.forum.controller;

import com.project.forum.config.JWUtil;

import com.project.forum.exceptions.UserServiceException;
import com.project.forum.repository.UserRepository;

import com.project.forum.request.LoginRequest;
import com.project.forum.request.RegisterRequest;
import com.project.forum.response.ApiResponse;
import com.project.forum.response.GetUsersResponse;
import com.project.forum.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    private final PasswordEncoder passWordEncoder;
    private final UserRepository userRepository;
    private final JWUtil jwUtil;
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody RegisterRequest registerRequest) {
        ApiResponse apiResponse = new ApiResponse();
        try{
            String response = userService.registerUser(registerRequest);
            apiResponse.setStatusCode(HttpStatus.ACCEPTED);
            apiResponse.setMessage(response);
            apiResponse.setSuccess(true);
            apiResponse.setData(null);
            apiResponse.setService("User Registration:"+ HttpStatus.OK.value());
            return ResponseEntity.ok(apiResponse);
        } catch (UserServiceException message) {
            apiResponse.setMessage(message.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("inside [LoginRequest] {}",loginRequest);
        ApiResponse apiResponse = new ApiResponse();
        try{
            String response = userService.userLogin(loginRequest);
            apiResponse.setStatusCode(HttpStatus.ACCEPTED);
            apiResponse.setMessage(response);
            apiResponse.setSuccess(true);
            apiResponse.setData(null);
            apiResponse.setService("User Login:"+ HttpStatus.OK.value());
            return ResponseEntity.ok(apiResponse);
        } catch (UserServiceException message) {
            apiResponse.setMessage(message.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);        }
    }

    @GetMapping("/{userName}")
    public GetUsersResponse getUser(@PathVariable String userName) {
            return userService.findByUsername(userName);
    }

}
