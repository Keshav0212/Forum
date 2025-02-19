package com.project.forum.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Document(collection = "reports")
public class Report {
    @Id
    @GeneratedValue
    private String id;
    private String title;
    private String description;
    private String location;
    private String image;
    private String userId;
    private String username;
    private String reportId;
}