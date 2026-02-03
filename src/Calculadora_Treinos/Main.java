package Calculadora_Treinos;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        int opcao;
        do {
            showMenu();
            opcao = InputHelper.readInteger("Escolha uma opcao: ");
            handlerOptions(opcao);
        }while(opcao != 0);
    }

    public static void showMenu() {
        System.out.println("+ ----------------------- +");
        System.out.println("|   [1] Pace da corrida   |");
        System.out.println("|   [2] Tempo estimado    |");
        System.out.println("|   [3] Conversor de pace |");
        System.out.println("|   [4] Pace natacao      |");
        System.out.println("|   [5] Split por km      |");
        System.out.println("|   [0] Sair              |");
        System.out.println("+ ----------------------- +");
    }

    public static void handlerOptions(int option) {
        switch (option) {
            case 0 -> System.out.println("Encerrando...");
            case 1 -> CalculadoraTreino.CalcularPaceCorrida();
            default -> System.out.println("Escolha uma opcao existente!");
        }
    }

 }
