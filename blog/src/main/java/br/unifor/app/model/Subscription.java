package br.unifor.app.model;

import javax.persistence.*;


@Table(name ="subscription")
@Entity
public class Subscription {
    @Id // Primary Key
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String user_email;

    @ManyToOne
    Category category;

    public Subscription() {  }

    public Subscription(String user_email) {
        this.user_email = user_email;
    }

    public int getId() {
        return id;
    }

    public String getUser_email() {
        return user_email;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
