package entities;

public class Usuario {
    private String nome;
    private Integer id;

    public Usuario(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("ID: ").append(id).append("\n");
        return sb.toString();
    }
}
