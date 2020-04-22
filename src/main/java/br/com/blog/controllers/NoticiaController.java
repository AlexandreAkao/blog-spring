package br.com.blog.controllers;

import br.com.blog.models.Noticia;
import br.com.blog.services.NoticiaService;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            System.out.println(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable("id") int id) {
        try {
            Noticia noticia = this.noticiaService.getOne(id);

            return ResponseEntity.status(200).body(noticia);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro");
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
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        try {
            this.noticiaService.delete(id);

            return ResponseEntity.status(200).body("Noticia de id = " + id + " foi deletada");
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro");
        }
    }
}
