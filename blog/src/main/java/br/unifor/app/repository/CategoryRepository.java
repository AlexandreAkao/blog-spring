package br.unifor.app.repository;
import br.unifor.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // QUERY NATIVA DO SQL...
    // AQUI FICAM AS QUERIES QUE VOCÊ FAZ NO BANCO.

    @Query(value = "SELECT * FROM category", nativeQuery = true)
    List<Category> findAll();

    @Query(value = "SELECT * FROM category WHERE id = ?1", nativeQuery = true)
    Category findOne(int id);
}
