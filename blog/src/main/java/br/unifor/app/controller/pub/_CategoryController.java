package br.unifor.app.controller.pub;

import br.unifor.app.model.Category;
import br.unifor.app.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class _CategoryController {
    private final CategoryService categoryService;

    public _CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // READ ALL - GET http://localhost:8081/category
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        try {
            var category = categoryService.getAll();
            return ResponseEntity.status(200).body(category);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
