package com.project.forum.service;

import com.project.forum.entity.Report;
import com.project.forum.request.CreateReportRequest;
import org.springframework.http.ResponseEntity;

public interface ReportService {
    public ResponseEntity<Report> getReport(String username, String title);
    public String createReport(CreateReportRequest createReportRequest);
    public String deleteReport(String username, String title);
    public String editReport(CreateReportRequest createReportRequest);
}