package com.project.forum.controller;

import com.project.forum.config.JWUtil;
import com.project.forum.dto.UserDto;
import com.project.forum.entity.Roles;
import com.project.forum.entity.User;
import com.project.forum.repository.UserRepository;
import com.project.forum.req.UserReq;
import com.project.forum.request.LoginRequest;
import com.project.forum.response.LoginResponse;
import com.project.forum.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Slf4j
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
    public String createUser(@RequestBody UserReq userReq) {
        User user = new User();
        user.setUsername(userReq.getUsername());
        user.setPassword(passWordEncoder.encode(userReq.getPassword()));
        user.setRoles(Roles.User);
        userRepository.save(user);
        return "User has been registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        log.info("inside [LoginRequest] {}",loginRequest);
        return userService.userLogin(loginRequest);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getUser(@PathVariable String userName){
        User user = new User();
//        userRepository.findByUsername(userName);
        return ResponseEntity.ok().body(userRepository.findByUsername(userName));
    }

}
