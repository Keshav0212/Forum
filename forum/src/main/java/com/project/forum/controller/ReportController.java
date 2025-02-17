package com.project.forum.controller;

import com.project.forum.entity.Report;
import com.project.forum.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportRepository reportRepository;

    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        reportRepository.save(report);
        return report;
    }

    @GetMapping
    public List<Report> getAllReports() {
       return reportRepository.findAll();
    }

    @GetMapping("/{userId}")
    public List<Report> getAllReportsofAUser(@PathVariable long userId) {
        return reportRepository.findByUserId();
    }






}
