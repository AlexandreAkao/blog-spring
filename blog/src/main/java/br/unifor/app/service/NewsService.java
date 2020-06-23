package br.unifor.app.service;
import br.unifor.app.model.Image;
import br.unifor.app.model.News;
import br.unifor.app.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    // AQUI VOCÊ DEFINE AS FUNÇOES QUE VAO INTERAGIR COM O BANCO.
    // SAVE E DELETE SAO FUNCOES NATIVAS DA JPA.

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News save(News item) {
        return newsRepository.save(item);
    }

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News getOne(int id) {
        return newsRepository.findOne(id);
    }

    public News update(int id, News item){
        News news = newsRepository.findOne(id);
        news.setText(item.getText());
        news.setTitle(item.getTitle());
        return newsRepository.save(news);
    }

    public void delete(int id) {
        News news = newsRepository.findOne(id);
        newsRepository.delete(news);
    }

    public List<News> searchByTitle(String title){
        return newsRepository.findByTitle(title);
    }


}
