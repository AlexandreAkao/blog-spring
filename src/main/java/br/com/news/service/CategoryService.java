package br.com.news.service;

import br.com.news.model.Category;
import br.com.news.model.News;
import br.com.news.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category) {
        return this.categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Category getOne(int id) {
        if (!this.categoryRepository.existsById(id)) {
            throw new IllegalArgumentException();
        }

        return this.categoryRepository.getOne(id);
    }

    public Category update(int id, Category category) {
        if (!this.categoryRepository.existsById(id)) {
            throw new IllegalArgumentException();
        }

        Category updatedCategory = this.categoryRepository.getOne(id);

        updatedCategory.setName(category.getName());

        return this.categoryRepository.save(updatedCategory);
    }

    public void delete(int id) {
        if (!this.categoryRepository.existsById(id)) {
            throw new IllegalArgumentException();
        }

        this.categoryRepository.deleteById(id);
    }
}
