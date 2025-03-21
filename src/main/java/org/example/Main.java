package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe abstrata que representa uma moeda genérica
abstract class Moeda {
    protected double valor; // Valor da moeda

    // Construtor
    public Moeda(double valor) {
        this.valor = valor;
    }

    // Método abstrato para exibir informações da moeda
    public abstract void info();

    // Método abstrato para converter o valor para Real
    public abstract double converter();
}

// Classe que representa a moeda Real
class Real extends Moeda {
    // Construtor
    public Real(double valor) {
        super(valor);
    }

    // Implementação do método para exibir informações da moeda Real
    @Override
    public void info() {
        System.out.println("Real: R$ " + valor);
    }

    // Implementação do método para converter para Real
    @Override
    public double converter() {
        return valor; // O valor já está em Real
    }
}

// Classe que representa a moeda Dólar
class Dolar extends Moeda {
    // Construtor
    public Dolar(double valor) {
        super(valor);
    }

    // Implementação do método para exibir informações da moeda Dólar
    @Override
    public void info() {
        System.out.println("Dólar: US$ " + valor);
    }

    // Implementação do método para converter para Real
    @Override
    public double converter() {
        return valor * 5.0; // Supondo que 1 dólar = 5 reais
    }
}

// Classe que representa a moeda Euro
class Euro extends Moeda {
    // Construtor
    public Euro(double valor) {
        super(valor);
    }

    // Implementação do método para exibir informações da moeda Euro
    @Override
    public void info() {
        System.out.println("Euro: € " + valor);
    }

    // Implementação do método para converter para Real
    @Override
    public double converter() {
        return valor * 6.0; // Supondo que 1 euro = 6 reais
    }
}

// Classe que gerencia uma coleção de moedas
class Cofrinho {
    private List<Moeda> moedas; // Lista de moedas

    // Construtor
    public Cofrinho() {
        moedas = new ArrayList<>();
    }

    // Adiciona uma moeda ao cofrinho
    public void adicionar(Moeda moeda) {
        moedas.add(moeda);
        System.out.println("Moeda adicionada.");
    }

    // Remove uma moeda do cofrinho
    public void remover(Moeda moeda) {
        if (moedas.remove(moeda)) {
            System.out.println("Moeda removida.");
        } else {
            System.out.println("Moeda não encontrada no cofrinho.");
        }
    }

    // Lista todas as moedas do cofrinho
    public void listagemMoedas() {
        if (moedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
        } else {
            System.out.println("Moedas no cofrinho:");
            for (Moeda moeda : moedas) {
                moeda.info();
            }
        }
    }

    // Calcula o valor total convertido para Real
    public double totalConvertido() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.converter();
        }
        return total;
    }
}

// Classe principal com o método main
public class Main {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu do Cofrinho ---");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Calcular total convertido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Adicionar moeda
                    System.out.println("\nEscolha o tipo de moeda:");
                    System.out.println("1. Real");
                    System.out.println("2. Dólar");
                    System.out.println("3. Euro");
                    System.out.print("Opção: ");
                    int tipoMoeda = scanner.nextInt();
                    System.out.print("Digite o valor: ");
                    double valor = scanner.nextDouble();

                    Moeda moeda = null;
                    switch (tipoMoeda) {
                        case 1:
                            moeda = new Real(valor);
                            break;
                        case 2:
                            moeda = new Dolar(valor);
                            break;
                        case 3:
                            moeda = new Euro(valor);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    if (moeda != null) {
                        cofrinho.adicionar(moeda);
                    }
                    break;

                case 2: // Remover moeda
                    System.out.println("\nEscolha o tipo de moeda para remover:");
                    System.out.println("1. Real");
                    System.out.println("2. Dólar");
                    System.out.println("3. Euro");
                    System.out.print("Opção: ");
                    tipoMoeda = scanner.nextInt();
                    System.out.print("Digite o valor: ");
                    valor = scanner.nextDouble();

                    Moeda moedaRemover = null;
                    switch (tipoMoeda) {
                        case 1:
                            moedaRemover = new Real(valor);
                            break;
                        case 2:
                            moedaRemover = new Dolar(valor);
                            break;
                        case 3:
                            moedaRemover = new Euro(valor);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    if (moedaRemover != null) {
                        cofrinho.remover(moedaRemover);
                    }
                    break;

                case 3: // Listar moedas
                    cofrinho.listagemMoedas();
                    break;

                case 4: // Calcular total convertido
                    double total = cofrinho.totalConvertido();
                    System.out.println("\nTotal no cofrinho convertido para Real: R$ " + total);
                    break;

                case 0: // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default: // Opção inválida
                    System.out.println("Opção inválida!");
                    break;
            }

            // Pausa para manter a resposta visível
            System.out.println("\nPressione ENTER para continuar...");
            scanner.nextLine(); // Limpa o buffer do teclado
            scanner.nextLine(); // Espera o usuário pressionar ENTER
        }
    }
}
