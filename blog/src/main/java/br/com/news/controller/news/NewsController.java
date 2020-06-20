package br.com.news.controller.news;

import br.com.news.model.News;
import br.com.news.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(@RequestParam(value = "title", required = false) String title) {
        try {
            List<News> newsList;

            if (title == null) {
                newsList = this.newsService.getAll();
            } else {
                newsList = this.newsService.findByTitle(title);
            }

            return ResponseEntity.status(200).body(newsList);

        } catch (Exception e) {
            Map<String, Object> res = new LinkedHashMap<>();
            res.put("error", "Ocorreu um erro");

            return new ResponseEntity<Object>(
                res,
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
