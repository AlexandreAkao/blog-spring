package br.com.comments.repository;

import br.com.comments.model.Comment;

import java.util.List;
import java.util.Map;

public interface CommentRepository {

    void save(Comment comment);
    Map<Integer, List<Comment>> findAll();
    List<Comment> findById(int id);
    void update(Comment comment);
    void delete(String id);
}
