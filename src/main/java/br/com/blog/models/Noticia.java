package br.com.blog.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "noticias")
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private String conteudo;

    public Noticia() {}

    public Noticia(int id, String autor, String titulo, Date data, String conteudo) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.data = data;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
