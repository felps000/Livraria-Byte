package br.com.livrariaByte.controller;

import br.com.livrariaByte.model.*;

import java.util.ArrayList;

public class SistemaBiblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Usuario buscarUsuario(String numeroRegistro) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroRegistro().equals(numeroRegistro)) {
                return usuario;
            }
        }
        return null;
    }

    public Funcionario buscarFuncionario(String idFuncionario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getIdFuncionario().equals(idFuncionario)) {
                return funcionario;
            }
        }
        return null;
    }

    public void exibirFuncionarioId(String idFuncionario) {
        Funcionario funcionario = buscarFuncionario(idFuncionario);
        if (funcionario != null) {
            funcionario.exibirInformacoes();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public Livro buscarLivro(String codigoLivro) {
        for (Livro livro : livros) {
            if (livro.getCodigoLivro().equals(codigoLivro)) {
                return livro;
            }
        }
        return null;
    }

    public Exemplar buscarExemplar(String codigoExemplar) {
        for (Livro livro : livros) {
            for (Exemplar exemplar : livro.getExemplares()) {
                if (exemplar.getCodigoExemplar().equals(codigoExemplar)) {
                    return exemplar;
                }
            }
        }
        return null;
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println("Número de Registro: " + usuario.getNumeroRegistro() + ", Nome: " + usuario.getNomeCompleto());
        }
    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID Funcional: " + funcionario.getIdFuncionario() + ", Nome: " + funcionario.getNomeCompleto());
        }
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            livro.exibirInformacoesLivro();
        }
    }

    public void listarExemplaresDisponiveis(String codigoLivro) {
        Livro livro = buscarLivro(codigoLivro);
        if (livro != null) {
            livro.listarExemplaresDisponiveis();
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void realizarEmprestimo(String numeroRegistroUsuario, String codigoLivro, String dataEmprestimo) {
        Usuario usuario = buscarUsuario(numeroRegistroUsuario);
        Livro livro = buscarLivro(codigoLivro);

        if (usuario != null && livro != null) {
            Exemplar exemplarDisponivel = livro.buscarExemplarDisponivel();
            if (exemplarDisponivel != null) {
                usuario.registrarEmprestimo(exemplarDisponivel, dataEmprestimo);
            } else {
                System.out.println("Não há exemplares disponíveis.");
            }
        } else {
            System.out.println("Usuário ou livro não encontrado.");
        }
    }

    public void realizarDevolucao(String numeroRegistroUsuario, String codigoExemplar, String dataDevolucao) {
        Usuario usuario = buscarUsuario(numeroRegistroUsuario);
        Exemplar exemplar = buscarExemplar(codigoExemplar);

        if (usuario != null && exemplar != null) {
            usuario.registrarDevolucao(exemplar, dataDevolucao);
        } else {
            System.out.println("Usuário ou exemplar não encontrado.");
        }
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void exibirTotalMultas() {
        double totalMulta = 0;
        for (Usuario usuario : usuarios) {
            totalMulta += usuario.getMulta();
        }
        System.out.println("Total de Multas: R$" + totalMulta);
    }
}
