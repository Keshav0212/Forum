package com.project.forum.repository;

import com.project.forum.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportRepository extends MongoRepository<Report, String> {
    List<Report> findByUserId();
}
