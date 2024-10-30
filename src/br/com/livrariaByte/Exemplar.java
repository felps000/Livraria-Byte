package br.com.livrariaByte;

public class Exemplar {
    private String codigoExemplar;
    private String estadoConservacao;
    private boolean disponivel;

    public Exemplar(String codigoExemplar, String estadoConservacao) {
        this.codigoExemplar = codigoExemplar;
        this.estadoConservacao = estadoConservacao;
        this.disponivel = true;
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
    }
}
