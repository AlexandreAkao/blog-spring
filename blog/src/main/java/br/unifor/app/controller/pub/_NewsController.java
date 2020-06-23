package br.unifor.app.controller.pub;
import br.unifor.app.model.News;
import br.unifor.app.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("news")
public class _NewsController {
    private final NewsService newsService;

    public _NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // READ ALL - GET http://localhost:8081/news
    // SEARCH BY TITLE - GET http://localhost:8081/news?title=
    @GetMapping
    public ResponseEntity<List<News>> newsGetPublic(@RequestParam(required = false, name = "title") String title) {
        try {
            if (title != null) {
                var news = newsService.searchByTitle(title);
                return ResponseEntity.status(200).body(news);
            } else {
                var news = newsService.getAll();
                return ResponseEntity.status(200).body(news);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }

}
