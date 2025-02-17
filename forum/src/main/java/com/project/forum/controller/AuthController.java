package com.project.forum.controller;

import com.project.forum.config.JWUtil;
import com.project.forum.entity.User;
import com.project.forum.repository.UserRepo;
import com.project.forum.req.UserReq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthController {


    private final PasswordEncoder passWordEncoder;
    private final UserRepo userRepo;
    private final JWUtil jwUtil;
//
//    public  AuthController(UserRepo userRepo, PasswordEncoder passwordEncoder, JWUtil jwtUtil) {
//        this.userRepo = userRepo;
//        this.passWordEncoder = passwordEncoder;
//        this.jwUtil = jwtUtil;
//    }

    @PostMapping("/register")
    public String createUser(@RequestBody UserReq userReq) {
        User user = new User();
        user.setUsername(userReq.getUsername());
        user.setPassword(passWordEncoder.encode(userReq.getPassword()));
        return "User has been registered successfully";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserReq user) {
        Optional<User> existingUser = userRepo.findByUsername(user.getUsername());
        if(existingUser.isPresent() && passWordEncoder.matches(user.getPassword(), existingUser.get().getPassword())) {
            String token = jwUtil.generateToken(user.getUsername());
            return Map.of("token", token);
        }
        return Map.of("error", "Invalid credentials");
    }
    


}
