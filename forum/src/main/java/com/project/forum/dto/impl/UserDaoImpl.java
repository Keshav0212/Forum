package com.project.forum.dto.impl;

import com.project.forum.dto.UserDao;
import com.project.forum.entity.Roles;
import com.project.forum.entity.User;
import com.project.forum.repository.UserRepository;
import com.project.forum.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public String registerUser(RegisterRequest userReq) {
        User user = new User();
        user.setUsername(userReq.getUsername());
        user.setPassword(passwordEncoder.encode(userReq.getPassword()));
        user.setPhone(userReq.getPhone());
        user.setProfileName(userReq.getProfileName());
        user.setRoles(Roles.User);
        userRepository.save(user);
        return "User has been registered successfully";
    }
}
