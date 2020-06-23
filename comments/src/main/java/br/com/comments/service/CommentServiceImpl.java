package br.com.comments.service;

import br.com.comments.model.Comment;
import br.com.comments.model.Commentsql;
import br.com.comments.repository.CommentsqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class CommentServiceImpl implements CommentService {

    HashOperations<String, Integer, List<Comment>> hashOperations;

    @Autowired
    private CommentsqlRepository commentsqlRepository;

    public CommentServiceImpl(RedisTemplate<String, Comment> redisTemplate) {
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
    public List<Commentsql> findAll() {
        return commentsqlRepository.findAll();
    }

    @Override
    public Map<Integer, List<Comment>> findAllRedis() {
        return hashOperations.entries("COMMENT");
    }

    @Override
    public List<Commentsql> findByNewsId(int id) {
//        return hashOperations.get("COMMENT", id);
        return commentsqlRepository.findByNewsId(id);
    }

    @Override
    public void update(Comment comment) {
        save(comment);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("COMMENT", id);
    }

    @Override
    public void clean() {
        if (hashOperations.size("COMMENT") != 0) {
            Map<Integer, List<Comment>> allComments = hashOperations.entries("COMMENT");
            allComments.forEach((k, v) -> hashOperations.delete("COMMENT", k));
        }
    }
}
