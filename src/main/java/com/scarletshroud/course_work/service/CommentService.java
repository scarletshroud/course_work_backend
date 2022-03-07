package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.entity.Comment;
import com.scarletshroud.course_work.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Optional<List<Comment>> getCommentsBySpotId(Long id) {
        return commentRepository.getCommentsBySpotId(id);
    }

    public Optional<List<Comment>> getCommentsByTrickId(Long trickId) {
        return commentRepository.getCommentsByTrickId(trickId);
    }
}
