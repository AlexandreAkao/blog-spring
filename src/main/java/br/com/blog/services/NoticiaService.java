package br.com.blog.services;

import br.com.blog.models.Noticia;
import br.com.blog.repositories.NoticiaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {

    private NoticiaRepository noticiaRepository;

    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    public Noticia create(Noticia noticia) {
        return this.noticiaRepository.save(noticia);
    }

    public List<Noticia> getAll() {
        return this.noticiaRepository.findAll();
    }

    public Noticia getOne(int id) {
        return this.noticiaRepository.getOne(id);
    }

    public Noticia update(int id, Noticia newInfo) {
        Noticia noticia = this.noticiaRepository.getOne(id);

        if (!newInfo.getAutor().isEmpty()) {

            noticia.setAutor(newInfo.getAutor());
        }

        if (!newInfo.getTitulo().isEmpty()) {

            noticia.setTitulo(newInfo.getTitulo());
        }

        if (!(newInfo.getData().toString().equals(""))) {

            noticia.setData(newInfo.getData());
        }

        if (!newInfo.getConteudo().isEmpty()) {

            noticia.setConteudo(newInfo.getConteudo());
        }

        return this.noticiaRepository.save(noticia);
    }

    public void delete(int id) {
        this.noticiaRepository.deleteById(id);
    }
}
