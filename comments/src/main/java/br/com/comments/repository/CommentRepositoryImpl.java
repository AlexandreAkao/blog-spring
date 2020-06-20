package br.com.comments.repository;

import br.com.comments.model.Comment;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private RedisTemplate<String, Comment> redisTemplate;

    private HashOperations hashOperations;

    public CommentRepositoryImpl(RedisTemplate<String, Comment> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Comment comment) {
        hashOperations.put("COMMENT", comment.getId(), comment);
    }

    @Override
    public Map<String, Comment> findAll() {
        return hashOperations.entries("COMMENT");
    }

    @Override
    public Comment findById(int id) {
        return (Comment) hashOperations.get("COMMENT", id);
    }

    @Override
    public void update(Comment comment) {
        save(comment);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("COMMENT", id);
    }
}
