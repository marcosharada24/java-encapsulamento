package br.edu.fatecpg.banco.model;

public class ContaBancaria {
    private double saldo;
    private String titular;

    // Construtor que recebe o nome do titular e o saldo inicial
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0; // Valor padrão se o saldo inicial for negativo
            System.out.println("Saldo inicial não pode ser negativo. Definido como 0.");
        }
    }

    // Método para depositar um valor
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("O valor do depósito deve ser positivo.");
        }
    }

    // Método para sacar um valor
    public void sacar(double valor) {
        if (valor > 0) {
            if (valor <= saldo) {
                saldo -= valor;
                System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para o saque.");
            }
        } else {
            System.out.println("O valor do saque deve ser positivo.");
        }
    }

    // Métodos get para acessar saldo e titular
    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}

