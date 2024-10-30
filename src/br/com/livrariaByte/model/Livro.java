package br.com.livrariaByte.model;

import java.util.ArrayList;

public class Livro {
    private String codigoLivro;
    private String titulo;
    private String autor;
    private String genero;
    private String editora;
    private int anoPublicacao;
    private ArrayList<Exemplar> exemplares;

    public Livro(String codigoLivro, String titulo, String autor, String genero, String editora, int anoPublicacao) {
        this.codigoLivro = codigoLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<>();
    }

    public String getCodigoLivro() {
        return codigoLivro;
    }

    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }

    public Exemplar buscarExemplarDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                return exemplar;
            }
        }
        return null;
    }

    public void exibirInformacoesLivro() {
        System.out.println("Código do Livro: " + codigoLivro);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Gênero: " + genero);
        System.out.println("Editora: " + editora);
        System.out.println("Ano de Publicação: " + anoPublicacao);
    }

    public void listarExemplaresDisponiveis() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                exemplar.exibirInformacoesExemplar();
            }
        }
    }
}
