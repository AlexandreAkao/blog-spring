package br.unifor.app.service;
import br.unifor.app.model.Image;
import br.unifor.app.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image save(Image item) {
        return imageRepository.save(item);
    }

    public List<Image> searchAllImages(int input_id){
        return imageRepository.listNewImages(input_id);
    }
}
