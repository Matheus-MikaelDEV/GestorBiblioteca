package application;

import entities.Biblioteca;
import entities.Emprestimo;
import entities.Livro;
import entities.Usuario;
import entities.enums.GeneroLivro;
import entities.enums.StatusEmprestimo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Sistema de Biblioteca iniciado.");

        int opcao = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Biblioteca biblioteca = new Biblioteca();

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar Livro\n2 - Remover Livro\n3 - Adicionar Usuário\n4 - Remover Usuário\n5 - Registrar Empréstimo\n6 - Finalizar Empréstimo\n7 - Listar Tudo\n8 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar Livro:");

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("ISBN: ");
                    Integer ISBN = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Data de Publicação (dd/MM/yyyy): ");
                    String dataPublicacaoStr = sc.nextLine();
                    System.out.print("Gênero: ");
                    GeneroLivro generoLivro = GeneroLivro.valueOf(sc.nextLine().toUpperCase().replace(" ", "_").replace("Ã", "A"));

                    biblioteca.adicionarLivro(new Livro(titulo, autor, ISBN, sdf.parse(dataPublicacaoStr), generoLivro));

                    System.out.println("Livro adicionado com sucesso.");
                    break;
                case 2:
                    System.out.println("Remover Livro:");

                    System.out.print("Título do Livro a ser removido: ");
                    String tituloRemover = sc.nextLine();

                    for (Livro livro : biblioteca.getLivros()) {
                        if (livro.getTitulo().equalsIgnoreCase(tituloRemover)) {
                            biblioteca.removerLivro(livro);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Adicionar Usuário:");

                    System.out.print("Nome do Usuário: ");
                    String nomeUsuario = sc.nextLine();
                    System.out.print("ID do Usuário: ");
                    Integer idUsuario = sc.nextInt();
                    sc.nextLine();

                    biblioteca.adicionarUsuario(new Usuario(nomeUsuario, idUsuario));

                    System.out.println("Usuário adicionado com sucesso.");
                    break;
                case 4:
                    System.out.println("Remover Usuário:");

                    System.out.print("ID do Usuário a ser removido: ");
                    Integer idUsuarioRemover = sc.nextInt();
                    sc.nextLine();

                    for (Usuario usuario : biblioteca.getUsuarios()) {
                        if (usuario.getId().equals(idUsuarioRemover)) {
                            biblioteca.removerUsuario(usuario);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Registrar Empréstimo:");

                    System.out.print("Título do Livro: ");
                    String tituloEmprestimo = sc.nextLine();
                    System.out.print("ID do Usuário: ");
                    Integer idUsuarioEmprestimo = sc.nextInt();
                    sc.nextLine();

                    if (biblioteca.getLivros().isEmpty() || biblioteca.getUsuarios().isEmpty()) {
                        System.out.println("Nenhum livro ou usuário disponível para empréstimo.");
                        break;
                    }

                    for (Livro livro : biblioteca.getLivros()) {
                        if (livro.getTitulo().equalsIgnoreCase(tituloEmprestimo)) {
                            for (Usuario usuario : biblioteca.getUsuarios()) {
                                if (usuario.getId().equals(idUsuarioEmprestimo)) {
                                    System.out.print("Status do empréstimo: ");
                                    StatusEmprestimo statusEmprestimo = StatusEmprestimo.valueOf(sc.nextLine().toUpperCase().replace(" ", "_").replace("Ã", "A"));

                                    biblioteca.registrarEmprestimo(new Emprestimo(livro, usuario, new Date(), statusEmprestimo));

                                    System.out.println("Empréstimo registrado com sucesso.");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    System.out.println("Livro ou usuário não encontrado para o empréstimo.");
                    break;
                case 6:
                    System.out.println("Finalizar Empréstimo:");

                    System.out.print("Título do Livro: ");
                    String tituloFinalizar = sc.nextLine();
                    System.out.print("ID do Usuário: ");
                    Integer idUsuarioFinalizar = sc.nextInt();
                    sc.nextLine();

                    for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
                        if (emprestimo.getLivro().getTitulo().equalsIgnoreCase(tituloFinalizar) && emprestimo.getUsuario().getId().equals(idUsuarioFinalizar)) {
                            biblioteca.finalizarEmprestimo(emprestimo);

                            System.out.println("Empréstimo finalizado com sucesso.");
                            break;
                        }
                    }
                    break;
                case 7:
                    if (biblioteca.getLivros().isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        System.out.println("Livros cadastrados:");
                        for (Livro livro : biblioteca.getLivros()) {
                            System.out.println(livro);
                        }
                    }

                    if (biblioteca.getUsuarios().isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("Usuários cadastrados:");
                        for (Usuario usuario : biblioteca.getUsuarios()) {
                            System.out.println(usuario);
                        }
                    }

                    if (biblioteca.getEmprestimos().isEmpty()) {
                        System.out.println("Nenhum empréstimo registrado.");
                    } else {
                        System.out.println("Empréstimos registrados:");
                        for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
                            System.out.println(emprestimo);
                        }
                    }

                    System.out.println("Listagem concluída.");
                    break;
                case 8:
                    System.out.println("Saindo do sistema de biblioteca.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 8);
    }
}