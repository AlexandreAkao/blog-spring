package br.com.news.service;

import br.com.news.model.Image;
import br.com.news.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getByNews(int news_id) {
        return this.imageRepository.findByNews(news_id);
    }

    public Image create(Image image) {
        return this.imageRepository.save(image);
    }
}
