package br.com.comments.config;

import br.com.comments.model.Comment;
import br.com.comments.model.commentsql;
import br.com.comments.repository.CommentsqlRepository;
import br.com.comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@EnableAsync
@EnableScheduling
public class RedisHandle {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentsqlRepository commentsqlRepository;

    @Async
    @Scheduled(fixedDelay = 20000)
    public void redisToMysql() {
        Map<Integer, List<Comment>> allComments = commentService.findAll();

        allComments.forEach((k, v) -> {
            v.forEach(c -> {
                System.out.println(k + ":" + c.getComment());
                commentsqlRepository.save(new commentsql(c.getNewsId(), c.getComment(), c.getName(), c.getEmail()));
            });
        });

        commentService.clean();
    }
}
