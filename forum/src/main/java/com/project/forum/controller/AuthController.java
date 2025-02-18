package com.project.forum.controller;

import com.project.forum.config.JWUtil;
import com.project.forum.dto.UserDto;
import com.project.forum.entity.User;
import com.project.forum.repository.UserRepository;
import com.project.forum.req.UserReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class AuthController {


    private final PasswordEncoder passWordEncoder;
    private final UserRepository userRepository;
    private final JWUtil jwUtil;

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
        return "User has been registered successfully";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserReq user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser.isPresent() && passWordEncoder.matches(user.getPassword(), existingUser.get().getPassword())) {
            String token = jwUtil.generateToken(user.getUsername());
            return Map.of("token", token);
        }
        return Map.of("error", "Invalid credentials");
    }
    

    @GetMapping("/{userName}")
    public ResponseEntity<?> getUser(@PathVariable String userName){
        User user = new User();
//        userRepository.findByUsername(userName);
        return ResponseEntity.ok().body(userRepository.findByUsername(userName));
    }

}
