package br.com.news.repository;

import br.com.news.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query(value = "SELECT * FROM image WHERE news_id = ?1", nativeQuery = true)
    List<Image> findByNews(int new_id);
}
