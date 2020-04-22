package br.com.blog.controllers;

import br.com.blog.models.Noticia;
import br.com.blog.services.NoticiaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {

    private final NoticiaService noticiaService;

    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @GetMapping
    public ResponseEntity getAll() {
        try {
            List<Noticia> noticias = this.noticiaService.getAll();

            return ResponseEntity.status(200).body(noticias);
        } catch (Exception e) {
            Map<String, Object> res = new LinkedHashMap<>();
            res.put("error", "Ocorreu um erro");

            return new ResponseEntity<Object>(
                    res,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable("id") int id) {
        try {
            Noticia noticia = this.noticiaService.getOne(id);

            return ResponseEntity.status(200).body(noticia);
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

    @PostMapping
    public ResponseEntity create(@RequestBody Noticia noticia) {
        try {
            Noticia newNoticia = this.noticiaService.create(noticia);

            return ResponseEntity.status(201).body(newNoticia);
        } catch (Exception e) {

            System.out.println(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody Noticia noticia) {
        try {
            Noticia updatedNoticia = this.noticiaService.update(id, noticia);

            return ResponseEntity.status(200).body(updatedNoticia);
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
    public ResponseEntity delete(@PathVariable("id") int id) {
        try {
            this.noticiaService.delete(id);

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
