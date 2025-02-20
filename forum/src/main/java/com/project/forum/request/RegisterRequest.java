package com.project.forum.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String profileName;
    private String phone;
}
