package br.com.livrariaByte.view;

import br.com.livrariaByte.controller.SistemaBiblioteca;
import br.com.livrariaByte.model.*;

public class LivrariaByte {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // --- Cadastro de Usuários ---
        Usuario usuario = new Usuario("Felipe Rocha", "(11)94153-2005", "Rua Raul, 123", "U001");
        sistema.adicionarUsuario(usuario);

        // --- Cadastro de Funcionários ---
        Funcionario funcionario1 = new Funcionario("Cristiano Gravino", "(11)96401-1011", "Rua das ruas, 699", "F001", "Atendimento");
        Funcionario funcionario2 = new Funcionario("Marcelo Lallo", "(11)98199-2713", "Rua Garantida, 24", "F002", "Caixa");
        sistema.adicionarFuncionario(funcionario1);
        sistema.adicionarFuncionario(funcionario2);

        // --- Busca e exibição de um funcionário ---
        System.out.println("\n--- Buscando Funcionário ---");
        sistema.exibirFuncionario("F001"); // Exibe informações do funcionário com ID "F001"

        // --- Listagem de todos os usuários cadastrados ---
        System.out.println("\n--- Listagem de Usuários Cadastrados ---");
        sistema.listarUsuarios();

        // --- Listagem de todos os funcionários cadastrados ---
        System.out.println("\n--- Listagem de Funcionários Cadastrados ---");
        sistema.listarFuncionarios();

        // --- Cadastro de Livros e Exemplares ---
        Livro livro = new Livro("LIV001", "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "HarperCollins", 1954);
        Exemplar exemplar1 = new Exemplar("EX001", "Ótimo");
        Exemplar exemplar2 = new Exemplar("EX002", "Bom");
        livro.adicionarExemplar(exemplar1);
        livro.adicionarExemplar(exemplar2);
        sistema.adicionarLivro(livro);

        // --- Listagem de todos os livros cadastrados ---
        System.out.println("\n--- Listagem de Livros Cadastrados ---");
        sistema.listarLivros();

        // --- Listagem de exemplares disponíveis de um livro específico ---
        System.out.println("\n--- Listagem de Exemplares Disponíveis para o Livro ---");
        sistema.listarExemplaresDisponiveis("LIV001");

        // --- Empréstimo de Livro ---
        System.out.println("\n--- Empréstimo de Livro ---");
        sistema.realizarEmprestimo("U001", "LIV001", "11/12/2023"); // Realiza empréstimo para o usuário "U001"

        // --- Devolução de Livro ---
        System.out.println("\n--- Devolução de Livro ---");
        sistema.realizarDevolucao("U001", "EX001", "27/12/2023"); // Devolve o exemplar "EX001"

        // --- Exibição de informações do usuário após operações ---
        System.out.println("\n--- Informações do Usuário Após Empréstimo e Devolução ---");
        sistema.exibirUsuario("U001");

        // --- Exibição do total de multas acumuladas ---
        System.out.println("\n--- Resumo e Multas ---");
        sistema.exibirTotalMultas();
    }
}
