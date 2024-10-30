package br.com.livrariaByte;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String codigoLivro;
    private String titulo;
    private String autor;
    private String genero;
    private List<Exemplar> exemplares;

    public Livro(String codigoLivro, String titulo, String autor, String genero) {
        this.codigoLivro = codigoLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.exemplares = new ArrayList<>();
    }

    public String getCodigoLivro() {
        return codigoLivro;
    }

    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public List<Exemplar> getExemplares() {
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
    }

    public void listarExemplaresDisponiveis() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                exemplar.exibirInformacoesExemplar();
            }
        }
    }
}
