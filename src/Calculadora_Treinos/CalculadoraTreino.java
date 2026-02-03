package Calculadora_Treinos;

import java.text.DecimalFormat;

public class CalculadoraTreino {

    public static void CalcularPaceCorrida() {
        System.out.println("\nPace corrida");
        double distancia = InputHelper.readDouble("Informe a distancia percorrida em km: ");
        String tempoTotal = InputHelper.readString("Informe o tempo total da duracao nesse padrao (ex: hora:minuto:segundo): ");

        String regex = ":";

        String [] arrayString = tempoTotal.split(regex);

        int hora = Integer.parseInt(arrayString[0]);
        int minuto = Integer.parseInt(arrayString[1]);
        int segundo = Integer.parseInt(arrayString[2]);

        //<<Conta>>
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

        String paceFormatado = valorInteiro + ":" + (segundos >= 10 ? segundos : "0"+segundos);

        System.out.println();
        System.out.println("Seu pace foi de " + paceFormatado + " min/km");

    }
}
