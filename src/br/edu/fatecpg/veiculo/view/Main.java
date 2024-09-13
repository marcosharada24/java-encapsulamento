package br.edu.fatecpg.veiculo.view;

import br.edu.fatecpg.veiculo.model.Carro;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar informações ao usuário
        System.out.println("Digite as informações do carro:");

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        double capacidadeTanque = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Capacidade do tanque (em litros): ");
            try {
                capacidadeTanque = scanner.nextDouble();
                if (capacidadeTanque <= 0) {
                    System.out.println("A capacidade do tanque deve ser maior que zero.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido para a capacidade do tanque.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }

        // Criar o objeto Carro com as informações fornecidas
        Carro carro = new Carro(marca, modelo, capacidadeTanque);

        // Definindo valores para a taxa de abastecimento e o preço do combustível
        double taxaAbastecimento = 0;
        entradaValida = false;
        while (!entradaValida) {
            System.out.print("Taxa de abastecimento (em litros por minuto): ");
            try {
                taxaAbastecimento = scanner.nextDouble();
                if (taxaAbastecimento <= 0) {
                    System.out.println("A taxa de abastecimento deve ser maior que zero.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido para a taxa de abastecimento.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }

        double precoPorLitro = 0;
        entradaValida = false;
        while (!entradaValida) {
            System.out.print("Preço do combustível (por litro): ");
            try {
                precoPorLitro = scanner.nextDouble();
                if (precoPorLitro <= 0) {
                    System.out.println("O preço por litro deve ser maior que zero.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido para o preço do combustível.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }

        // Calculando tempo e custo para encher o tanque
        double tempoParaEncher = carro.calcularTempoParaEncher(taxaAbastecimento);
        double custoParaEncher = carro.calcularCustoParaEncher(precoPorLitro);

        // Exibindo os resultados
        if (tempoParaEncher >= 0) {
            System.out.println("Tempo necessário para encher o tanque: " + tempoParaEncher + " minutos");
        }
        if (custoParaEncher >= 0) {
            System.out.println("Custo total para encher o tanque: R$ " + custoParaEncher);
        }
    }
}

