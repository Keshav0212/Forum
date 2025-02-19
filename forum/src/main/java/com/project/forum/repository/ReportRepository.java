package com.project.forum.repository;

import com.project.forum.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends MongoRepository<Report, String> {
    List<Report> findByUserId(String userId);
    Optional<Report> findByUsernameAndTitle(String username, String title);
}
