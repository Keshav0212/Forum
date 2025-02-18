package com.project.forum.req;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class UserLoginReq {
    private String username;
    private String password;
//    private String profileName;
//    private String phone;
}
