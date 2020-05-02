package br.com.news.controller.image;

import br.com.news.model.Image;
import br.com.news.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageController {
    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getImageByNews(@PathVariable("id") int id) {
        try {

            List<Image> imageList = this.imageService.getByNews(id);

            return ResponseEntity.status(200).body(imageList);
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
