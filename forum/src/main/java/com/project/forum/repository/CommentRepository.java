package com.project.forum.repository;

import com.project.forum.entity.Comment;
import com.project.forum.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Report, String> {
    List<Report> findByUserId(long userId);
    Report findByUsernameAndTitle(String username, String title);
    List<Comment> findByReportId(String reportId);
}