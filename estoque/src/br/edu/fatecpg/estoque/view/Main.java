package br.edu.fatecpg.estoque.view;

import java.util.Scanner;

import br.edu.fatecpg.estoque.model.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registro de Produto");
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        double preco = 0;
        while (true) {
            System.out.print("Digite o preço do produto: ");
            String precoInput = scanner.nextLine();

            // Removendo todos os caracteres que não sejam números, ponto ou vírgula
            precoInput = precoInput.replaceAll("[^\\d.,]", "");
            precoInput = precoInput.replaceAll(",", ".");  // Substituindo vírgula por ponto
            precoInput = precoInput.replaceFirst("\\.(?=.*\\.)", "");  // Mantendo apenas o último ponto

            try {
                preco = Double.parseDouble(precoInput);

                // Verificando se o preço é negativo
                if (preco >= 0) {
                    break;  // Sai do loop se o preço for válido
                } else {
                    System.out.println("Erro: O preço não pode ser negativo. Por favor, tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Formato de preço inválido. Por favor, tente novamente.");
            }
        }

        int quantidadeEstoque = 0;
        while (true) {
            System.out.print("Digite a quantidade em estoque: ");
            quantidadeEstoque = scanner.nextInt();

            // Verificando se a quantidade em estoque é negativa
            if (quantidadeEstoque >= 0) {
                break;  // Sai do loop se a quantidade for válida
            } else {
                System.out.println("Erro: A quantidade em estoque não pode ser negativa. Por favor, tente novamente.");
            }
        }

        Produto produto = new Produto(nome, preco, quantidadeEstoque);

        System.out.println("\nProduto registrado com sucesso!");
        produto.exibirProduto();
    }
}




