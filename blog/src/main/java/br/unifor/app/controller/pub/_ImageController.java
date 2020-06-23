package br.unifor.app.controller.pub;


import br.unifor.app.model.Image;
import br.unifor.app.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("image")
public class _ImageController {

    private final ImageService imageService;

    public _ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // LIST IMAGES OF NEWS_ID - GET http://localhost:8081/image/news/4
    @GetMapping("/news/{id}")
    public ResponseEntity<List<Image>> getByTitle(@PathVariable("id") int id) {
        try {
            var image = imageService.searchAllImages(id);
            System.out.println("teste de print");
            return ResponseEntity.status(200).body(image);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }
}
