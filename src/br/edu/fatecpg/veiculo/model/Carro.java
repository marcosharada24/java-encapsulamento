package br.edu.fatecpg.veiculo.model;

public class Carro {
    private String chassi = "Não informado"; // Valor padrão
    private String modelo;
    private String marca;
    private String placa;
    private double motor = 1.0; // Valor padrão
    private double capacidadeTanque; // Capacidade do tanque em litros

    public Carro(String marca, String modelo, double capacidadeTanque) {
        this.marca = marca;
        this.modelo = modelo;
        setCapacidadeTanque(capacidadeTanque); // Usando o setter para validação
    }

    // Métodos get e set para capacidadeTanque com validação
    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        if (capacidadeTanque > 0) {
            this.capacidadeTanque = capacidadeTanque;
        } else {
            System.out.println("A capacidade do tanque deve ser maior que zero.");
        }
    }

    // Métodos get e set para chassi
    public String getChassi() {
        return this.chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    // Métodos get e set para motor
    public double getMotor() {
        return this.motor;
    }

    public void setMotor(double motor) {
        if (motor > 0) {
            this.motor = motor;
        } else {
            System.out.println("O valor do motor deve ser maior que zero.");
        }
    }

    // Método para calcular o tempo necessário para encher o tanque
    public double calcularTempoParaEncher(double taxaAbastecimento) {
        if (taxaAbastecimento <= 0) {
            System.out.println("A taxa de abastecimento deve ser maior que zero.");
            return -1;
        }
        return capacidadeTanque / taxaAbastecimento;
    }

    // Método para calcular o custo total para encher o tanque
    public double calcularCustoParaEncher(double precoPorLitro) {
        if (precoPorLitro <= 0) {
            System.out.println("O preço por litro deve ser maior que zero.");
            return -1;
        }
        return capacidadeTanque * precoPorLitro;
    }

    // Outros getters e setters
    public String getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getPlaca() {
        return this.placa;
    }
}
