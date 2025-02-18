package com.project.forum.service.impl;

import com.project.forum.config.JWUtil;
import com.project.forum.dto.UserDao;
import com.project.forum.entity.User;
import com.project.forum.repository.UserRepository;
import com.project.forum.request.LoginRequest;
import com.project.forum.request.RegisterRequest;
import com.project.forum.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
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
        }
        return "Invalid Credentials";
    }

    @Override
    public String registerUser(RegisterRequest userReq) {
        return  userDao.registerUser(userReq);
    }
}
