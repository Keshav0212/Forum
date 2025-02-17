package com.project.forum.repository;

import com.project.forum.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByReportId(String reportId);  // Finds all comments related to a specific reportId
}
