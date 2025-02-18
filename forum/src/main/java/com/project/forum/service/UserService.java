package com.project.forum.service;

import com.project.forum.request.LoginRequest;
import com.project.forum.request.RegisterRequest;

public interface UserService {
    String userLogin(LoginRequest loginRequest);

    String registerUser(RegisterRequest userReq);
}
