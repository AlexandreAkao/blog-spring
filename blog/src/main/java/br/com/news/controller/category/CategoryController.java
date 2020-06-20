package br.com.news.controller.category;

import br.com.news.model.Category;
import br.com.news.model.News;
import br.com.news.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        try {
            List<Category> categoryList = this.categoryService.getAll();

            return ResponseEntity.status(200).body(categoryList);

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
