package br.com.livrariaByte;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Usuario extends Pessoa {
    private String numeroRegistro;
    private double multa;
    private ArrayList<Emprestimo> emprestimos;

    public Usuario(String nomeCompleto, String telefone, String endereco, String numeroRegistro) {
        super(nomeCompleto, telefone, endereco);
        this.numeroRegistro = numeroRegistro;
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
            Emprestimo emprestimo = new Emprestimo(exemplar.getCodigoExemplar(), dataDevolucao); // Ajuste: só passamos os dois parâmetros necessários
            emprestimos.add(emprestimo);
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
                if (LocalDate.parse(dataDevolucaoAtual, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        .isAfter(LocalDate.parse(emprestimo.getDataDevolucao(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
                    multa += 5.0; // Atraso gera multa de R$5.00
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
        System.out.println("Multa: R$" + multa);
    }
}
