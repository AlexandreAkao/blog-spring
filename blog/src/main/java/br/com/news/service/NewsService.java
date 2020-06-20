package br.com.news.service;

import br.com.news.model.News;
import br.com.news.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News create(News news) {
        return this.newsRepository.save(news);
    }

    public List<News> getAll() {
        return this.newsRepository.findAll();
    }

    public List<News> findByTitle(String title) {
        return this.newsRepository.findByTitle(title);
    }

    public News getOne(int id) {
        if (!this.newsRepository.existsById(id)) {
            throw new IllegalArgumentException();
        }

        return this.newsRepository.getOne(id);
    }

    public News update(int id, News news) {
        if (!this.newsRepository.existsById(id)) {
            throw new IllegalArgumentException();
        }

        News updatedNew = this.newsRepository.getOne(id);

        updatedNew.setCategory(news.getCategory());
        updatedNew.setText(news.getText());
        updatedNew.setTitle(news.getTitle());

        return this.newsRepository.save(updatedNew);
    }

    public void delete(int id) {
        if (!this.newsRepository.existsById(id)) {
            throw new IllegalArgumentException();
        }

        this.newsRepository.deleteById(id);
    }
}
