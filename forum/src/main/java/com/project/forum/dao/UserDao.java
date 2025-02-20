package com.project.forum.dao;

import com.project.forum.entity.User;
import com.project.forum.request.RegisterRequest;
import com.project.forum.response.GetUsersResponse;

import java.util.Optional;


public interface UserDao {
    String registerUser(RegisterRequest registerRequest);
    GetUsersResponse findByUsername(String username);
}
