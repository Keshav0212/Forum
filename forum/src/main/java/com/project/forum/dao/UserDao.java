package com.project.forum.dao;

import com.project.forum.request.RegisterRequest;


public interface UserDao {
    String registerUser(RegisterRequest registerRequest);
}
