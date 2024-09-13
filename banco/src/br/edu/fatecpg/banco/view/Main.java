package br.edu.fatecpg.banco.view;

import br.edu.fatecpg.banco.model.ContaBancaria;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Locale para número decimal
        Locale locale = Locale.getDefault(); // Ou use um específico, como Locale.US para ponto decimal
        NumberFormat numberFormat = NumberFormat.getInstance(locale);

        // Solicitar informações da conta ao usuário
        System.out.println("Bem-vindo ao sistema bancário!");

        // Obter nome do titular
        System.out.print("Digite o nome do titular da conta: ");
        String titular = scanner.nextLine();

        // Obter saldo inicial
        double saldoInicial = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Digite o saldo inicial da conta (valor positivo): ");
            String entrada = scanner.nextLine();
            try {
                saldoInicial = numberFormat.parse(entrada).doubleValue();
                if (saldoInicial >= 0) {
                    entradaValida = true;
                } else {
                    System.out.println("O saldo inicial deve ser positivo.");
                }
            } catch (ParseException e) {
                System.out.println("Formato inválido. Por favor, insira um número válido.");
            }
        }

        // Criar a conta bancária
        ContaBancaria conta = new ContaBancaria(titular, saldoInicial);

        // Realizar operações bancárias
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Ver saldo");
            System.out.println("4. Sair");

            int opcao = 0;
            entradaValida = false;
            while (!entradaValida) {
                System.out.print("Digite a opção desejada: ");
                String entradaOpcao = scanner.nextLine();
                try {
                    opcao = Integer.parseInt(entradaOpcao);
                    if (opcao >= 1 && opcao <= 4) {
                        entradaValida = true;
                    } else {
                        System.out.println("Opção inválida. Escolha uma opção de 1 a 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, insira um número válido.");
                }
            }

            switch (opcao) {
                case 1: // Depositar
                    double valorDeposito = 0;
                    entradaValida = false;
                    while (!entradaValida) {
                        System.out.print("Digite o valor a ser depositado: ");
                        String entradaDeposito = scanner.nextLine();
                        try {
                            valorDeposito = numberFormat.parse(entradaDeposito).doubleValue();
                            if (valorDeposito > 0) {
                                entradaValida = true;
                            } else {
                                System.out.println("O valor do depósito deve ser positivo.");
                            }
                        } catch (ParseException e) {
                            System.out.println("Formato inválido. Por favor, insira um número válido.");
                        }
                    }
                    conta.depositar(valorDeposito);
                    break;

                case 2: // Sacar
                    double valorSaque = 0;
                    entradaValida = false;
                    while (!entradaValida) {
                        System.out.print("Digite o valor a ser sacado: ");
                        String entradaSaque = scanner.nextLine();
                        try {
                            valorSaque = numberFormat.parse(entradaSaque).doubleValue();
                            if (valorSaque > 0) {
                                entradaValida = true;
                            } else {
                                System.out.println("O valor do saque deve ser positivo.");
                            }
                        } catch (ParseException e) {
                            System.out.println("Formato inválido. Por favor, insira um número válido.");
                        }
                    }
                    conta.sacar(valorSaque);
                    break;

                case 3: // Ver saldo
                    System.out.println("Saldo atual da conta de " + conta.getTitular() + ": R$ " + numberFormat.format(conta.getSaldo()));
                    break;

                case 4: // Sair
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção de 1 a 4.");
                    break;
            }
        }

        // Fechar o scanner
        scanner.close();
    }
}

