import br.com.livrariaByte.*;

public class LivrariaByte {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // Criando usuário
        Usuario usuario = new Usuario("Felipe Rocha", "(11)94153-2005", "Rua Lallo, 123", "U001");
        sistema.adicionarUsuario(usuario);

        // Criando funcionários
        Funcionario funcionario1 = new Funcionario("Cristiano Gravino", "(11)96401-1011", "Rua Avenida, 456", "F001", "Atendimento");
        sistema.adicionarFuncionario(funcionario1);

        // Exibindo funcionários cadastrados
        sistema.listarFuncionarios();

        // Criando livro
        Livro livro = new Livro("LIV001", "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia");
        livro.adicionarExemplar(new Exemplar("EX001", "Ótimo"));
        sistema.adicionarLivro(livro);

        // Exibindo todos os livros
        sistema.listarLivros();

        // Listando exemplares disponíveis do livro
        sistema.listarExemplaresDisponiveis("LIV001");

        // Realizando empréstimo
        sistema.realizarEmprestimo("U001", "LIV001", "11/12/2023");

        // Realizando devolução
        sistema.realizarDevolucao("U001", "EX001", "27/12/2023");

        // Listando todos os usuários
        sistema.listarUsuarios();

        // Exibindo total de multas acumuladas (opção extra)
        sistema.exibirTotalMultas();
    }
}

