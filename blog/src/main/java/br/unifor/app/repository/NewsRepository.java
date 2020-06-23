package br.unifor.app.repository;

import br.unifor.app.model.Image;
import br.unifor.app.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {
    // QUERY NATIVA DO SQL...
    // AQUI FICAM AS QUERIES QUE VOCÊ FAZ NO BANCO.

    @Query(value = "SELECT * FROM news", nativeQuery = true)
    List<News> findAll();

    @Query(value = "SELECT * FROM news WHERE id = ?1", nativeQuery = true)
    News findOne(int id);

    @Query(value = "SELECT n FROM News n WHERE n.title LIKE %:title%")
    List<News> findByTitle(String title);

    @Query(value = "select * from image where news_id = ?1", nativeQuery = true)
    List<Image> listNewImages(int input_id);
}
