package com.project.forum.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Entity
@Document(collection = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Username (email) cannot be null")
    @NotEmpty(message = "Username (email) cannot be empty")
    @Email(message = "Username must be a valid email address")
    private String username;

    @NotNull(message = "Profile name cannot be null")
    @NotEmpty(message = "Profile name cannot be empty")
    @Size(min = 3, max = 100, message = "Profile name must be between 3 and 100 characters")
    private String profileName;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotEmpty(message = "Phone number should not be empty")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be valid (e.g., +1234567890 or 1234567890)")
    private String phone;

    private List<Long> followers;
    private List<Long> following;

    @NotNull(message = "Roles cannot be null")
    private Roles roles;

}
