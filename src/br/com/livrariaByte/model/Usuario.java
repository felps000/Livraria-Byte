package br.com.livrariaByte.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Usuario extends Pessoa {
    private String numeroRegistro;
    private String email;
    private LocalDate dataCadastro;
    private ArrayList<String> livrosEmprestados;
    private double multa;
    private ArrayList<Emprestimo> emprestimos;

    public Usuario(String nomeCompleto, String telefone, String endereco, String numeroRegistro) {
        super(nomeCompleto, telefone, endereco);
        this.numeroRegistro = numeroRegistro;
        this.email = numeroRegistro + "@biblioteca.com";
        this.dataCadastro = LocalDate.now();
        this.livrosEmprestados = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.multa = 0.0;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public double getMulta() {
        return multa;
    }

    public void registrarEmprestimo(Exemplar exemplar, String dataEmprestimo) {
        if (exemplar.isDisponivel()) {
            exemplar.setDisponivel(false);
            String dataDevolucao = calcularDataDevolucao(dataEmprestimo);
            Emprestimo emprestimo = new Emprestimo(exemplar.getCodigoExemplar(), dataDevolucao);
            emprestimos.add(emprestimo);
            livrosEmprestados.add(exemplar.getCodigoExemplar());
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Exemplar não disponível para empréstimo.");
        }
    }

    private String calcularDataDevolucao(String dataEmprestimo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataEmprestimoDate = LocalDate.parse(dataEmprestimo, formatter);
        LocalDate dataDevolucaoDate = dataEmprestimoDate.plusDays(15);
        return dataDevolucaoDate.format(formatter);
    }

    public void registrarDevolucao(Exemplar exemplar, String dataDevolucaoAtual) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getCodigoExemplar().equals(exemplar.getCodigoExemplar())) {
                exemplar.setDisponivel(true);
                emprestimo.setDataDevolucao(dataDevolucaoAtual); // Registro da data de devolução
                if (LocalDate.parse(dataDevolucaoAtual, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        .isAfter(LocalDate.parse(emprestimo.getDataDevolucao(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
                    multa += 5.0;
                    System.out.println("Devolução atrasada! Multa de R$5.00 aplicada.");
                }
                System.out.println("Devolução registrada com sucesso!");
                break;
            }
        }
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Número de Registro: " + numeroRegistro);
        System.out.println("Email: " + email);
        System.out.println("Data de Cadastro: " + dataCadastro);
        System.out.println("Multa: R$" + multa);
        System.out.println("Livros Emprestados: " + livrosEmprestados);
    }
}
