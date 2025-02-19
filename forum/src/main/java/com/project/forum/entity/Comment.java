package com.project.forum.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String reportId;
    private String userId;
    private String text;
}
