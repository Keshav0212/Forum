package com.project.forum.controller;

import com.project.forum.entity.Comment;
import com.project.forum.repository.CommentRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
//@Slf4j
//@CrossOrigin(origins = "http://localhost:5173")
public class CommentController {

    private final CommentRepository commentRepository;

//    public CommentController(CommentRepository commentRepository) {
//        this.commentRepository = commentRepository;
//    }


    @PostMapping
    public String createComment(@RequestBody Comment comment) {

//         commentRepository.save(comment);
         return "Comment Successfull";
    }

    @GetMapping("/report/{reportId}")
    public List<Comment> getCommentsByReport(@PathVariable String reportId) {
        return commentRepository.findByReportId(reportId);
    }

}
