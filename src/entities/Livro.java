package entities;

import entities.enums.GeneroLivro;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Livro {
    private String titulo;
    private String autor;
    private Integer ISBN;
    private Date dataPublicacao;
    private GeneroLivro genero;

    public Livro(String titulo, String autor, Integer ISBN, Date dataPublicacao, GeneroLivro genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.dataPublicacao = dataPublicacao;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public GeneroLivro getGenero() {
        return genero;
    }

    public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    StringBuilder sb = new StringBuilder();

    sb.append("Título: ").append(titulo).append("\n");
    sb.append("Autor: ").append(autor).append("\n");
    sb.append("ISBN: ").append(ISBN).append("\n");
    sb.append("Data de Publicação: ").append(sdf.format(dataPublicacao)).append("\n");
    sb.append("Gênero: ").append(genero).append("\n");
    return sb.toString();
    }
}
