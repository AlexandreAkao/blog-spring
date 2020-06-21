package br.com.comments.repository;

import br.com.comments.model.Comment;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    HashOperations<String, Integer, List<Comment>> hashOperations;

    public CommentRepositoryImpl(RedisTemplate<String, Comment> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Comment comment) {
        List<Comment> currentComments = hashOperations.get("COMMENT", comment.getNewsId());

        if (currentComments == null) {
            List<Comment> commentList = new ArrayList<>();
            commentList.add(comment);
            hashOperations.put("COMMENT", comment.getNewsId(), commentList);

        } else {
            currentComments.add(comment);
            hashOperations.put("COMMENT", comment.getNewsId(), currentComments);
        }

        System.out.println(String.format("User with ID %s saved", comment.getNewsId()));
    }

    @Override
    public Map<Integer, List<Comment>> findAll() {
        return hashOperations.entries("COMMENT");
    }

    @Override
    public List<Comment> findById(int id) {
        return hashOperations.get("COMMENT", id);
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
