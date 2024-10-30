package br.com.livrariaByte;

public class Emprestimo {
    private String codigoExemplar;
    private String dataDevolucao;

    public Emprestimo(String codigoExemplar, String dataDevolucao) {
        this.codigoExemplar = codigoExemplar;
        this.dataDevolucao = dataDevolucao;
    }

    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }
}


