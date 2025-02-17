package com.project.forum.req;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserReq {
    private String username;
    private String password;
    private String profileName;
    private String phone;
}
