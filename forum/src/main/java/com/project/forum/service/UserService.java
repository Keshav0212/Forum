package com.project.forum.service;

import com.project.forum.entity.User;
import com.project.forum.request.LoginRequest;
import com.project.forum.request.RegisterRequest;
import com.project.forum.response.GetUsersResponse;

import java.util.Optional;

public interface UserService {
    GetUsersResponse findByUsername(String username);
    String userLogin(LoginRequest loginRequest);
    String registerUser(RegisterRequest registerRequest);
}
