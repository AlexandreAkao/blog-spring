package br.com.comments.repository;

import br.com.comments.model.Comment;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    HashOperations<String, Integer, Comment> hashOperations;

    public CommentRepositoryImpl(RedisTemplate<String, Comment> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Comment comment) {
        hashOperations.put("COMMENT", comment.getId(), comment);
        System.out.println(String.format("User with ID %s saved", comment.getId()));
    }

    @Override
    public Map<Integer, Comment> findAll() {
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
