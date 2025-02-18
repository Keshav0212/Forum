package com.project.forum.request;

import lombok.Data;

@Data
public class CreateReportRequest {
    private long id;
    private String title;
    private String description;
    private String location;
    private String image;
    private String userId;
}
