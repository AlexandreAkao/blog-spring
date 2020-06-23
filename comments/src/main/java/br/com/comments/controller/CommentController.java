package br.com.comments.controller;

import br.com.comments.model.Comment;
import br.com.comments.model.Commentsql;
import br.com.comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping()
    public Comment add(@RequestBody Map<String, String> body) {
        Comment newComment = new Comment(
                Integer.parseInt(body.get("newsId")),
                body.get("comment"),
                body.get("name"),
                body.get("email"),
                new Date()
        );
        commentService.save(newComment);

        return newComment;
    }

    @GetMapping()
    public List<Commentsql> findAll() {
        System.out.println(commentService.findAll());
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public List<Commentsql> getById(@PathVariable int id) {
        return commentService.findByNewsId(id);
    }
}
