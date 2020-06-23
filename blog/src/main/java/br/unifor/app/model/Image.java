package br.unifor.app.model;

import javax.persistence.*;

@Table(name ="image")
@Entity
public class Image {
    @Id // Primary Key
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String source;

    @ManyToOne
    News news;

    public Image() {  }

    public Image(String source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
