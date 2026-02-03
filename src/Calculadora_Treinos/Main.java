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
            case 1 -> paceCorrida();
            default -> System.out.println("Escolha uma opcao existente!");
        }
    }

    public static void paceCorrida() {
        System.out.println("\nPace corrida");
        double distancia = InputHelper.readDouble("Informe a distancia percorrida em km: ");
        String tempoTotal = InputHelper.readString("Informe o tempo total da duracao nesse padrao (ex: hora:minuto:segundo): ");

        String regex = ":";

        String [] arrayString = tempoTotal.split(regex);

        int hora = Integer.parseInt(arrayString[0]);
        int minuto = Integer.parseInt(arrayString[1]);
        int segundo = Integer.parseInt(arrayString[2]);

        //conta
        //tranformar tudo em minutos e somar
        //dividir o total em minutos pela distancia total
        //pegar o decimal do total em minutos e multiplicar por 60 para obter os segundos
        //mostrar os valores formatados

        double tempoTotalMinutos = ((hora*60) + ((double) segundo / 60) + minuto) / distancia;//convertendo o valor total para minutos
        int valorInteiro = (int)tempoTotalMinutos;//pegando o valor inteiro dos minutos
        double valorDecimal = tempoTotalMinutos - valorInteiro;//pegando o valor decimal dos minutos

        DecimalFormat formatter = new DecimalFormat("0.00");

        double valorDecimalFormatado = Double.parseDouble(formatter.format(valorDecimal));

        int segundos = (int) (valorDecimalFormatado*60);

        System.out.println();
        System.out.println("Seu pace foi de " + valorInteiro + ":" + segundos + " min/km");
    }

 }
