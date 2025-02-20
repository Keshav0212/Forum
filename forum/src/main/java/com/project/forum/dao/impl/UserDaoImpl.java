package com.project.forum.dao.impl;

import com.project.forum.dao.UserDao;
import com.project.forum.entity.User;
import com.project.forum.repository.UserRepository;
import com.project.forum.request.RegisterRequest;
import com.project.forum.response.GetUsersResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public GetUsersResponse findByUsername(String username) {
        User user= userRepository.findByUsername(username);
        GetUsersResponse response = new GetUsersResponse();
        response.setUsername(user.getUsername());
        response.setProfileName(user.getProfileName());
        response.setPhone(user.getPhone());
        response.setFollowers_Count(user.getFollowers() != null ? user.getFollowers().size() : 0);
        response.setFollowing_Count(user.getFollowing() != null ? user.getFollowing().size() : 0);
        return response;
    }
}
