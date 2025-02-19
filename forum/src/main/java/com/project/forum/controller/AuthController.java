package com.project.forum.controller;

import com.project.forum.config.JWUtil;

import com.project.forum.entity.User;
import com.project.forum.exceptions.UserServiceException;
import com.project.forum.repository.UserRepository;

import com.project.forum.request.LoginRequest;
import com.project.forum.request.RegisterRequest;
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

//    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JWUtil jwtUtil) {
//        this.userRepository = userRepository;
//        this.passWordEncoder = passwordEncoder;
//        this.jwUtil = jwtUtil;
//    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@Valid @RequestBody RegisterRequest registerRequest) {
        try{
            String response = userService.registerUser(registerRequest);
            return ResponseEntity.ok(response);
        } catch (UserServiceException message) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("inside [LoginRequest] {}",loginRequest);
        try{
            String response = userService.userLogin(loginRequest);
            return ResponseEntity.ok(response);
        } catch (UserServiceException message) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message.getMessage());
        }
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getUser(@PathVariable String userName){
        User user = new User();
//        userRepository.findByUsername(userName);
        return ResponseEntity.ok().body(userRepository.findByUsername(userName));
    }

}
