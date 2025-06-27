package entities;

import entities.enums.StatusEmprestimo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private Date dataEmprestimo;
    private StatusEmprestimo status;

    public Emprestimo(Livro livro, Usuario usuario, Date dataEmprestimo, StatusEmprestimo status) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("Empréstimo de livro: ").append(livro.getTitulo()).append("\n");
        sb.append("Usuário: ").append(usuario.getNome()).append("\n");
        sb.append("Data do Empréstimo: ").append(sdf.format(dataEmprestimo)).append("\n");
        sb.append("Status: ").append(status).append("\n");
        return sb.toString();
    }
}
