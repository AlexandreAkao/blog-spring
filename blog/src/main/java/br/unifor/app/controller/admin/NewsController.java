package br.unifor.app.controller.admin;
import br.unifor.app.service.NewsService;
import br.unifor.app.model.News;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("admin/news")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // CREATE - POST http://localhost:8081/admin/news
    @PostMapping
    public ResponseEntity<News> add(@RequestBody News body) {
        try {
            var news = newsService.save(body);
            return ResponseEntity.status(201).body(news);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }

    // READ ALL - GET http://localhost:8081/admin/news
    @GetMapping
    public ResponseEntity<List<News>> getAll() {
        try {
            var news = newsService.getAll();
            return ResponseEntity.status(200).body(news);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }

    // READ ONE - GET http://localhost:8081/admin/news/:id
    @GetMapping("/{id}")
    public ResponseEntity<News> getOne(@PathVariable("id") int id) {
        try {
            var news = newsService.getOne(id);
            return ResponseEntity.status(200).body(news);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }

    // UPDATE - PUT http://localhost:8081/admin/news/:id
    @PutMapping("/{id}")
    public ResponseEntity<News> update(@PathVariable("id") int id, @RequestBody News body){
        try {
            var news = newsService.update(id, body);
            return ResponseEntity.status(204).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }

    // DELETE - DEL http://localhost:8081/admin/news/id
    @DeleteMapping("/{id}")
    public ResponseEntity<News> deleteOne(@PathVariable("id") int id) {
        try {
            newsService.delete(id);
            return ResponseEntity.status(200).build();
        } catch (Exception ex) {
            return ResponseEntity.status(404).build();
        }
    }

}
