package br.com.livrariaByte.model;

import java.time.LocalDate;

public class Exemplar {
    private String codigoExemplar;
    private String estadoConservacao;
    private boolean disponivel;
    private LocalDate dataAquisicao;

    public Exemplar(String codigoExemplar, String estadoConservacao) {
        this.codigoExemplar = codigoExemplar;
        this.estadoConservacao = estadoConservacao;
        this.disponivel = true;
        this.dataAquisicao = LocalDate.now();
    }

    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void exibirInformacoesExemplar() {
        System.out.println("Código do Exemplar: " + codigoExemplar);
        System.out.println("Estado de Conservação: " + estadoConservacao);
        if (disponivel) {
            System.out.println("Disponível: Sim");
        } else {
            System.out.println("Disponível: Não");
        }
        System.out.println("Data de Aquisição: " + dataAquisicao);
    }
}
