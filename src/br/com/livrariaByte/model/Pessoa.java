package br.com.livrariaByte.model;

public abstract class Pessoa {
    protected String nomeCompleto;
    protected String telefone;
    protected String endereco;

    public Pessoa(String nomeCompleto, String telefone, String endereco) {
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nomeCompleto);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
    }
}
