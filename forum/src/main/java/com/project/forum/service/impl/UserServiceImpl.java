package com.project.forum.service.impl;

import com.project.forum.config.JWUtil;
import com.project.forum.dao.UserDao;
import com.project.forum.entity.User;
import com.project.forum.exceptions.UserServiceException;
import com.project.forum.repository.UserRepository;
import com.project.forum.request.LoginRequest;
import com.project.forum.request.RegisterRequest;
import com.project.forum.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passWordEncoder;
    private final JWUtil jwUtil;
    private final UserDao userDao;

    @Override
    public String userLogin(LoginRequest loginRequest) {
        Optional<User> existingUser = userRepository.findByUsername(loginRequest.getUsername());
        if(existingUser.isPresent() && passWordEncoder.matches(loginRequest.getPassword(), existingUser.get().getPassword())){
            log.info("inside [userLogin] {}",passWordEncoder.matches(loginRequest.getPassword(), existingUser.get().getPassword()));
            return "Login Successful";
        } else {
            throw new UserServiceException("Invalid Credentials");
        }
    }

    @Override
    public String registerUser(RegisterRequest registerRequest) {
        if(userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new UserServiceException("User Already Exists!! Try again with different Username");
        }
        userDao.registerUser(registerRequest);
        return "User has been registered successfully";
    }
}
