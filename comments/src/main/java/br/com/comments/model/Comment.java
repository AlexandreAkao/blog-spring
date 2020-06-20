package br.com.comments.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private int newsId;
    private String comment;
    private String name;
    private String email;

    public Comment(int newsId, String comment, String name, String email) {
        this.newsId = newsId;
        this.comment = comment;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return newsId;
    }

    public void setId(int id) {
        this.newsId = id;
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
}
