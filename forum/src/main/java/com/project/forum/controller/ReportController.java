package com.project.forum.controller;

import com.project.forum.entity.Report;
import com.project.forum.repository.ReportRepository;
import com.project.forum.request.CreateReportRequest;
import com.project.forum.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final ReportRepository reportRepository;


    @GetMapping("/{username}/{title}")
    Report getReport(@PathVariable String username, String title){
        return reportService.getReport(username, title);
    }

    @PostMapping("/createreport")
    public String createReport(@RequestBody CreateReportRequest createReportRequest) {
        reportService.createReport(createReportRequest);
        return "Report Created Successfully";
    }

    @DeleteMapping("/deletereport/{username}/{title}")
    public String deleteReport(@PathVariable String username, String title){
        return reportService.deleteReport(username, title);
    }

    @PostMapping("/editreport")
    public String editReport(@RequestBody CreateReportRequest createReportRequest){
        return reportService.editReport(createReportRequest);
    }
}
