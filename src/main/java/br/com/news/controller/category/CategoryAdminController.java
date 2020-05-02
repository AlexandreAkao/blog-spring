package br.com.news.controller.category;

import br.com.news.model.Category;
import br.com.news.model.News;
import br.com.news.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/category")
public class CategoryAdminController {

    private CategoryService categoryService;

    public CategoryAdminController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Category category) {
        try {
            Category newCategory = this.categoryService.create(category);

            return ResponseEntity.status(201).body(newCategory);
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
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody Category category) {
        try {
            Category updatedCategory = this.categoryService.update(id, category);

            return ResponseEntity.status(200).body(updatedCategory);
        } catch (IllegalArgumentException e) {

            Map<String, Object> res = new LinkedHashMap<>();
            res.put("error", "Nao foi encontrado a categoria de id=" + id);

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
            this.categoryService.delete(id);

            Map<String, Object> res = new LinkedHashMap<>();
            res.put("sucess", "Categoria de id = " + id + " foi deletada");

            return new ResponseEntity<Object>(
                    res,
                    HttpStatus.OK
            );
        } catch (IllegalArgumentException e) {

            Map<String, Object> res = new LinkedHashMap<>();
            res.put("error", "Nao foi encontrado a categoria de id=" + id);

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
