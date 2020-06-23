package br.unifor.app.repository;

import br.unifor.app.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query(value = "SELECT * FROM news", nativeQuery = true)
    List<Image> findAll();

    @Query(value = "select * from image where news_id = ?1", nativeQuery = true)
    List<Image> listNewImages(int input_id);

}
