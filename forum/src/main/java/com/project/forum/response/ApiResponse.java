package com.project.forum.response;

import lombok.Data;

@Data
public class ApiResponse {
    private int statusCode;
    private boolean success;
    private String message;
    private String service;
    private Object data;
}
