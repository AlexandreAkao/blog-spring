package br.com.comments.controller;

import br.com.comments.model.Comment;
import br.com.comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping()
    public List<Comment> add(@RequestBody Map<String, String> body) {

        commentService.save(
            new Comment(
                Integer.parseInt(body.get("newsId")),
                body.get("comment"),
                body.get("name"),
                body.get("email")
        ));

        return commentService.findById(Integer.parseInt(body.get("newsId")));
    }

    @GetMapping()
    public Map<Integer, List<Comment>> findAll() {
        System.out.println(commentService.findAll());
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public List<Comment> getById(@PathVariable int id) {
        return commentService.findById(id);
    }
}
