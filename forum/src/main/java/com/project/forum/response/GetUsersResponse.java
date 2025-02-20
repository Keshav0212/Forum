package com.project.forum.response;

import com.project.forum.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class GetUsersResponse {
    User user = new User();
    private String username;
    private String profileName;
    private String phone;
    private int followers_Count = user.getFollowers() != null ? user.getFollowers().size() : 0;// Prevent NullPointerException
    private int following_Count = user.getFollowing() != null ? user.getFollowing().size() : 0;// Prevent NullPointerException

    public String getPassword () {
        return user.getPassword();
    }

}
