package com.project.forum.dto;

import com.project.forum.request.RegisterRequest;

public interface UserDao {

    String registerUser(RegisterRequest userReq);
}
