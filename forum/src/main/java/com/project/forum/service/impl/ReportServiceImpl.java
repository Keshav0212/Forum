package com.project.forum.service.impl;

import com.project.forum.entity.Report;
import com.project.forum.repository.CommentRepository;
import com.project.forum.repository.ReportRepository;
import com.project.forum.request.CreateReportRequest;
import com.project.forum.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    @Override
    public Report getReport(String username, String title) {
        Report report = reportRepository.findByUsernameAndTitle(username, title);
        return report;
    }

    @Override
    public String createReport(CreateReportRequest createReportRequest) {
        Report report = new Report();
        report.setId(createReportRequest.getId());
        report.setTitle(createReportRequest.getTitle());
        report.setImage(createReportRequest.getImage());
        report.setDescription(createReportRequest.getDescription());
        report.setLocation((createReportRequest.getLocation()));
        reportRepository.save(report);
        return "Report Created Successfully";
    }

    @Override
    public String deleteReport(String username, String title) {
        Report report = reportRepository.findByUsernameAndTitle(username, title);
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
        reportRepository.save(report);
        return "edited the report";
    }
}
