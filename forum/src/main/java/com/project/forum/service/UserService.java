package com.project.forum.service;

import com.project.forum.request.LoginRequest;

public interface UserService {
    String userLogin(LoginRequest loginRequest);
}
