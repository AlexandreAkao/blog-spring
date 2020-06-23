package br.unifor.app.controller.admin;

import br.unifor.app.model.Image;
import br.unifor.app.model.News;
import br.unifor.app.service.CategoryService;
import br.unifor.app.service.ImageService;
import br.unifor.app.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("admin/image")

public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // CREATE - POST http://localhost:8081/admin/image
    @PostMapping
    public ResponseEntity<Image> add(@RequestBody Image body) {
        try {
            var image = imageService.save(body);
            return ResponseEntity.status(201).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }
}
