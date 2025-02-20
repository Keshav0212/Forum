package com.project.forum.controller;

import com.project.forum.entity.Report;
import com.project.forum.repository.ReportRepository;
import com.project.forum.request.CreateReportRequest;
import com.project.forum.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
@Slf4j
public class ReportController {

    private final ReportService reportService;
    private final ReportRepository reportRepository;


    @GetMapping("/{username}/{title}")
    public ResponseEntity<Report> getReport(@PathVariable String username, @PathVariable String title) {

       ResponseEntity<Report> report = reportService.getReport(username, title);

        log.info("[getReport Service was called], report {} :", report);
        return ResponseEntity.ok(report.getBody());
    }

    @PostMapping("/createreport")
    public String createReport(@RequestBody CreateReportRequest createReportRequest) {
        reportService.createReport(createReportRequest);
        return "Report Created Successfully";
    }

    @DeleteMapping("/deletereport/{username}/{title}")
    public String deleteReport(@PathVariable String username, @PathVariable String title) {
        return reportService.deleteReport(username, title);
    }

    @PostMapping("/editreport")
    public String editReport(@RequestBody CreateReportRequest createReportRequest){
        return reportService.editReport(createReportRequest);
    }


}