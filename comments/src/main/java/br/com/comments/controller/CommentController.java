package br.com.comments.controller;

import br.com.comments.model.Comment;
import br.com.comments.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping()
    public List<Comment> add(@RequestBody Map<String, String> body) {

        commentRepository.save(
            new Comment(
                Integer.parseInt(body.get("newsId")),
                body.get("comment"),
                body.get("name"),
                body.get("email")
        ));

        return commentRepository.findById(Integer.parseInt(body.get("newsId")));
    }

    @GetMapping()
    public Map<Integer, List<Comment>> findAll() {
        System.out.println(commentRepository.findAll());
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Comment> getById(@PathVariable int id) {
        return commentRepository.findById(id);
    }
}
