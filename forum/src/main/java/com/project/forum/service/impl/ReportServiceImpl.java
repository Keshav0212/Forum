package com.project.forum.service.impl;

import com.project.forum.entity.Report;
import com.project.forum.repository.ReportRepository;
import com.project.forum.request.CreateReportRequest;
import com.project.forum.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    @Override
    public ResponseEntity<Report> getReport(String username, String title) {
        Report report = reportRepository.findByUsernameAndTitle(username, title).get();
        log.info("[getReport Service was called], report {} :", report);
        return ResponseEntity.ok(report);
    }


    @Override
    public String createReport(CreateReportRequest createReportRequest) {
        Report report = new Report();
        report.setId(createReportRequest.getId());
        report.setTitle(createReportRequest.getTitle());
        report.setImage(createReportRequest.getImage());
        report.setDescription(createReportRequest.getDescription());
        report.setLocation((createReportRequest.getLocation()));
        report.setUsername((createReportRequest.getUsername()));
        reportRepository.save(report);
        return "Report Created Successfully";
    }

    @Override
    public String deleteReport(String username, String title) {
        Report report = reportRepository.findByUsernameAndTitle(username, title).get();
        reportRepository.delete(report);
        return "Deleted the report";
    }

    @Override
    public String editReport(CreateReportRequest createReportRequest) {
        Report report = new Report();
        report.setId(createReportRequest.getId());
        report.setTitle(createReportRequest.getTitle());
        report.setImage(createReportRequest.getImage());
        report.setDescription(createReportRequest.getDescription());
        report.setLocation((createReportRequest.getLocation()));
        report.setUsername((createReportRequest.getUsername()));
        reportRepository.save(report);
        return "edited the report";
    }
}