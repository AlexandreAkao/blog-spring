package br.com.comments.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "comments")
@Entity
public class Commentsql {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "news_id", nullable = false)
    private int newsId;
    @Column(nullable = false)
    private String comment;
    @Column
    private String name;
    @Column
    private String email;
    @Column(name = "created_at")
    private Timestamp createdAt;

    public Commentsql() {
    }

    public Commentsql(int newsId, String comment, String name, String email, Timestamp createdAt) {
        this.newsId = newsId;
        this.comment = comment;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

