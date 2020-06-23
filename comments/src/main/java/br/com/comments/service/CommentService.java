package br.com.comments.service;

import br.com.comments.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface CommentService {

    void save(Comment comment);
    Map<Integer, List<Comment>> findAll();
    List<Comment> findById(int id);
    void update(Comment comment);
    void delete(String id);
    void clean();
}
