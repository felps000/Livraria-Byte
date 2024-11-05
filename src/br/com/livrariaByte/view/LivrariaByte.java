package br.com.livrariaByte.view;

import br.com.livrariaByte.controller.SistemaBiblioteca;
import br.com.livrariaByte.model.*;

public class LivrariaByte {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // Criando usuário
        Usuario usuario = new Usuario("Felipe Rocha", "(11)94153-2005", "Rua Raul, 123", "U001");
        sistema.adicionarUsuario(usuario);

        // Criando funcionários
        Funcionario funcionario1 = new Funcionario("Cristiano Gravino", "(11)96401-1011", "Rua das ruas, 699", "F001", "Atendimento");
        Funcionario funcionario2 = new Funcionario("Marcelo Lallo", "(11)98199-2713", "Rua Garantida, 24", "F002", "Caixa");
        sistema.adicionarFuncionario(funcionario1);
        sistema.adicionarFuncionario(funcionario2);

        System.out.println("\n--- Buscando funcionário ---");
        sistema.exibirFuncionarioId("F001");

        System.out.println("\n--- Listagem de Usuários Cadastrados ---");
        sistema.listarUsuarios();

        System.out.println("\n--- Listagem de Funcionários Cadastrados ---");
        sistema.listarFuncionarios();

        // Criando e adicionando livro
        Livro livro = new Livro("LIV001", "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "HarperCollins", 1954);
        Exemplar exemplar1 = new Exemplar("EX001", "Ótimo");
        Exemplar exemplar2 = new Exemplar("EX002", "Bom");
        livro.adicionarExemplar(exemplar1);
        livro.adicionarExemplar(exemplar2);
        sistema.adicionarLivro(livro);

        // Exibindo todos os livros cadastrados
        System.out.println("\n--- Listagem de Livros Cadastrados ---");
        sistema.listarLivros();

        // Exibindo exemplares disponíveis de um livro específico
        System.out.println("\n--- Listagem de Exemplares Disponíveis para o Livro ---");
        sistema.listarExemplaresDisponiveis("LIV001");

        System.out.println("\n--- Empréstimo de Livro ---");

        // Realizando um empréstimo de exemplar para o usuário
        sistema.realizarEmprestimo("U001", "LIV001", "11/12/2023");

        System.out.println("\n--- Devolução de Livro ---");

        // Realizando a devolução do exemplar
        sistema.realizarDevolucao("U001", "EX001", "27/12/2023");

        // Exibindo informações do usuário após o empréstimo e devolução
        System.out.println("\n--- Informações do Usuário Após Empréstimo e Devolução ---");
        sistema.buscarUsuario("U001").exibirInformacoes();

        System.out.println("\n--- Resumo e Multas ---");

        // Exibindo total de multas acumuladas no sistema
        sistema.exibirTotalMultas();
    }
}
