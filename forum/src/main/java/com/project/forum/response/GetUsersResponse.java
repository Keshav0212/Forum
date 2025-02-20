package com.project.forum.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.forum.entity.User;
import lombok.Data;

@Data
public class GetUsersResponse {

    @JsonIgnore  // This prevents "user" from appearing in the JSON response
    private User user = new User();

    private String username;
    private String profileName;
    private String phone;
    private int followers_Count;
    private int following_Count;

    public GetUsersResponse() {
        this.followers_Count = user.getFollowers() != null ? user.getFollowers().size() : 0; // Prevent NullPointerException
        this.following_Count = user.getFollowing() != null ? user.getFollowing().size() : 0; // Prevent NullPointerException
    }

    @JsonIgnore
    public String getPassword () {
        return user.getPassword();
    }
}
