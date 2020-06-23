package br.com.comments.model;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Table(name = "comments")
//@Entity
public class Comment implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
    private int newsId;
//    @Column(nullable = false)
    private String comment;
//    @Column()
    private String name;
//    @Column
    private String email;

    private Date created_at;

    public Comment(int newsId, String comment, String name, String email, Date created_at) {
        this.newsId = newsId;
        this.comment = comment;
        this.name = name;
        this.email = email;
        this.created_at = created_at;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}

