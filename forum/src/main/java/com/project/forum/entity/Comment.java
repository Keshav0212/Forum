package com.project.forum.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "comments")
public class Comment {
    @Id
    private long id;
    private long reportId;
    private String userId;
    private String text;
}
