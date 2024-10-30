package br.com.livrariaByte.model;

public class Funcionario extends Pessoa {
    private String idFuncionario;
    private String setor;

    public Funcionario(String nomeCompleto, String telefone, String endereco, String idFuncionario, String setor) {
        super(nomeCompleto, telefone, endereco);
        this.idFuncionario = idFuncionario;
        this.setor = setor;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("ID Funcional: " + idFuncionario);
        System.out.println("Setor: " + setor);
    }
}
