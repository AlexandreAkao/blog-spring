package br.unifor.app.model;

import javax.persistence.*;
import java.util.List;

@Table(name ="news")
@Entity
public class News {
    @Id // Primary Key
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    // Colunas

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    private Category category;

    public News() {  }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public News(String title, String text) {
        this.setTitle(title);
        this.setText(text);
    }

    public News(int id, String title, String text, Category category) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
