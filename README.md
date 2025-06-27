# 📚 Sistema de Biblioteca

Este é um projeto simples de sistema de gerenciamento de biblioteca feito em **Java**, com funcionalidades de cadastro de livros, usuários e empréstimos de livros.

## 🚀 Funcionalidades

- Adicionar e remover livros
- Adicionar e remover usuários
- Registrar e finalizar empréstimos
- Listar todos os livros, usuários e empréstimos
- Controle de status de empréstimos
- Suporte a diversos gêneros literários

## 🛠️ Estrutura do Projeto

```
📦biblioteca
 ┣ 📂entities
 ┃ ┣ 📜Biblioteca.java
 ┃ ┣ 📜Emprestimo.java
 ┃ ┣ 📜Livro.java
 ┃ ┣ 📜Usuario.java
 ┃ ┗ 📂enums
 ┃   ┣ 📜GeneroLivro.java
 ┃   ┗ 📜StatusEmprestimo.java
 ┣ 📂application
 ┃ ┗ 📜Program.java
```

### 📄 Descrição das classes principais

- **Program.java**: Classe principal com o menu interativo e lógica de entrada de dados.
- **Livro.java**: Representa um livro com título, autor, ISBN, data de publicação e gênero.
- **Usuario.java**: Representa um usuário com nome e ID.
- **Emprestimo.java**: Representa um empréstimo com livro, usuário, data e status.
- **Biblioteca.java**: Gerencia listas de livros, usuários e empréstimos.
- **GeneroLivro.java**: Enum com uma ampla lista de gêneros literários.
- **StatusEmprestimo.java**: Enum com diferentes estados de um empréstimo.

## ▶️ Exemplo de Uso

Abaixo está um exemplo de interação com o menu da aplicação no terminal:

```
Sistema de Biblioteca iniciado.
Menu:
1 - Adicionar Livro
2 - Remover Livro
3 - Adicionar Usuário
4 - Remover Usuário
5 - Registrar Empréstimo
6 - Finalizar Empréstimo
7 - Listar Tudo
8 - Sair
Escolha uma opção: 1
Adicionar Livro:
Título: O Senhor dos Anéis
Autor: J.R.R. Tolkien
ISBN: 123456
Data de Publicação (dd/MM/yyyy): 29/07/1954
Gênero: fantasia
Livro adicionado com sucesso.

Escolha uma opção: 3
Adicionar Usuário:
Nome do Usuário: Maria Oliveira
ID do Usuário: 101
Usuário adicionado com sucesso.

Escolha uma opção: 5
Registrar Empréstimo:
Título do Livro: O Senhor dos Anéis
ID do Usuário: 101
Status do empréstimo: em_andamento
Empréstimo registrado com sucesso.

Escolha uma opção: 7
Livros cadastrados:
Título: O Senhor dos Anéis
Autor: J.R.R. Tolkien
ISBN: 123456
Data de Publicação: 29/07/1954
Gênero: FANTASIA

Usuários cadastrados:
Nome: Maria Oliveira
ID: 101

Empréstimos registrados:
Empréstimo de livro: O Senhor dos Anéis
Usuário: Maria Oliveira
Data do Empréstimo: 27/06/2025
Status: EM_ANDAMENTO
```
