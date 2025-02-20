package com.project.forum.controller;

import com.project.forum.entity.Comment;
import com.project.forum.repository.CommentRepository;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @GetMapping("/report/{reportId}")
    public List<Comment> getCommentsByReport(@PathVariable String reportId) {
        return commentRepository.findByReportId(reportId);
    }

}
