package br.com.news.controller.news;

import br.com.news.model.News;
import br.com.news.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/news")
public class NewsAdminController {
    private final NewsService newsService;

    public NewsAdminController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody News news) {
        try {
            News newNews = this.newsService.create(news);

            return ResponseEntity.status(201).body(newNews);
        } catch (Exception e) {

            Map<String, Object> res = new LinkedHashMap<>();
            res.put("error", "Ocorreu um erro");

            return new ResponseEntity<Object>(
                    res,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody News news) {
        try {
            News updatedNews = this.newsService.update(id, news);

            return ResponseEntity.status(200).body(updatedNews);
        } catch (IllegalArgumentException e) {

            Map<String, Object> res = new LinkedHashMap<>();
            res.put("error", "Nao foi encontrado a noticia de id=" + id);

            return new ResponseEntity<Object>(
                    res,
                    HttpStatus.NOT_FOUND
            );
        } catch (Exception e) {
            Map<String, Object> res = new LinkedHashMap<>();
            res.put("error", "Ocorreu um erro");

            return new ResponseEntity<Object>(
                    res,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        try {
            this.newsService.delete(id);

            Map<String, Object> res = new LinkedHashMap<>();
            res.put("sucess", "Noticia de id = " + id + " foi deletada");

            return new ResponseEntity<Object>(
                    res,
                    HttpStatus.OK
            );
        } catch (IllegalArgumentException e) {

            Map<String, Object> res = new LinkedHashMap<>();
            res.put("error", "Nao foi encontrado a noticia de id=" + id);

            return new ResponseEntity<Object>(
                    res,
                    HttpStatus.NOT_FOUND
            );
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
