package br.com.comments.repository;

import br.com.comments.model.Comment;

import java.util.Map;

public interface CommentRepository {

    void save(Comment comment);
    Map<Integer, Comment> findAll();
    Comment findById(int id);
    void update(Comment comment);
    void delete(String id);
}
