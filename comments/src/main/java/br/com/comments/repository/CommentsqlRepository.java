package br.com.comments.repository;

import br.com.comments.model.Commentsql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsqlRepository extends JpaRepository<Commentsql, Integer> {
    @Query(value = "SELECT * FROM comments WHERE news_id = ?1 ORDER BY created_at DESC", nativeQuery = true)
    List<Commentsql> findByNewsId(int id);
}
