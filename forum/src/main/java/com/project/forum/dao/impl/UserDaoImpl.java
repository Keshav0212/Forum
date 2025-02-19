package com.project.forum.dao.impl;

import com.project.forum.dao.UserDao;
import com.project.forum.entity.Roles;
import com.project.forum.entity.User;
import com.project.forum.repository.UserRepository;
import com.project.forum.request.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Valid
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;
    private final PasswordEncoder passWordEncoder;

    @Override
    public String registerUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passWordEncoder.encode(registerRequest.getPassword()));
        user.setProfileName(registerRequest.getProfileName());
        user.setPhone(registerRequest.getPhone());
        userRepository.save(user);
        return "";
    }
}
