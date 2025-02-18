package com.project.forum.request;

import jakarta.validation.Valid;
import lombok.Data;

@Data
@Valid
public class RegisterRequest {

    private String username;
    private String password;
    private String profileName;
    private String phone;
}
