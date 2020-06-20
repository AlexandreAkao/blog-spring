package br.com.news.controller.image;

import br.com.news.model.Category;
import br.com.news.model.Image;
import br.com.news.repository.ImageRepository;
import br.com.news.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/image")
public class ImageAdminController {
    private ImageService imageService;

    public ImageAdminController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Image image) {
        try {
            Image newImage = this.imageService.create(image);

            return ResponseEntity.status(201).body(newImage);
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
