package Calculadora_Treinos;

import java.text.DecimalFormat;

public class CalculadoraTreino {

    public static void CalcularPaceCorrida() {

        System.out.println("\nPace corrida");
        float distancia = InputHelper.readFloat("Informe a distancia percorrida em km: ");

        String tempoTotal = InputHelper.readString("Informe o tempo total da duracao nesse padrao (ex: hora:minuto:segundo): ");

        String [] arrayString = tempoTotal.split(":");

        int hora = Integer.parseInt(arrayString[0]);
        int minuto = Integer.parseInt(arrayString[1]);
        int segundo = Integer.parseInt(arrayString[2]);

        //<<Conta>>
        //tranformar tudo em minutos e somar
        //dividir o total em minutos pela distancia total
        //pegar o decimal do total em minutos e multiplicar por 60 para obter os segundos
        //mostrar os valores formatados

        float tempoTotalMinutos = ((hora*60) + ((float) segundo / 60) + minuto) / distancia;//convertendo o valor total para minutos
        int valorInteiro = (int)tempoTotalMinutos;//pegando o valor inteiro dos minutos
        float valorDecimal = tempoTotalMinutos - valorInteiro;//pegando o valor decimal dos minutos

        //DecimalFormat formatter = new DecimalFormat("0.00");
        //double valorDecimalFormatado = Double.parseDouble(formatter.format(valorDecimal));

        //valor em double ->  5.6872037914691935
        //valor em float ->   5.687204

        System.out.println("Tempo total em minutos -> " + tempoTotalMinutos);

        int segundos = (int) (valorDecimal*60);

        String paceFormatado = valorInteiro + ":" + (segundos >= 10 ? segundos : "0"+segundos);

        System.out.println();
        System.out.println("Seu pace foi de " + paceFormatado + " min/km");

    }

    public static void CalcularTempoEstimado() {

        System.out.println("\nCalcular o tempo estimado");
        float distancia = InputHelper.readFloat("Informe a distancia a ser percorrida em km: ");
        String pace = InputHelper.readString("Informe o pace para percorrer a distancia ex(min:segundo): ");

        String [] arrayString = pace.split(":");//separando os valores informados para um array de string

        int minutos = Integer.parseInt(arrayString[0]);//pegando o valor do minutos informado
        int segundos = Integer.parseInt(arrayString[1]);//pegando o valor de segundos informado

        // transformando os segundos em minutos
        // somando o total de minutos e multiplicando pela distancia informada
        float tempoTotalEmMinutos = (minutos + ((float)segundos/60)) * distancia;

        int tempHoras = 0;
        int tempMinutos = (int) tempoTotalEmMinutos;// inicializando com o valor inteiro de minutos

        //Recalcula o tempo se o valor de minutos tiver horas
        if(tempoTotalEmMinutos >= 60) {
            tempHoras = (int) tempoTotalEmMinutos / 60;// pegando o valor de horas dentro dos minutos
            tempMinutos = tempMinutos - (tempHoras * 60);// pegando o valor real de minutos
        }

        //Calculando o tempo em segundos a partir do tempo total em minutos
        //Encontrando o valor decimal em minutos para multiplicar e resultar no valor em segundos
        int tempSegundos = (int) ((tempoTotalEmMinutos - (int)tempoTotalEmMinutos) * 60);

        //Mostrando o tempo estimado no padrao hh:mm:ss
        System.out.println("Tempo estimado -> " + FormatacaoTempo.FormatarTempoEstimado(tempHoras, tempMinutos, tempSegundos));
    }

    public static void ConverterPace() {

        System.out.println("\nConverter pace min/km para km/h");
        String pace = InputHelper.readString("Informe o seu pace ex (min:segundos): ");

        String [] arrayString = pace.split(":");

        int minutos = Integer.parseInt(arrayString[0]);
        int segundos = Integer.parseInt(arrayString[1]);

        float valorTotalEmMinutos = minutos + ((float)segundos/60);

        float velocidadeKmPorH = 60/valorTotalEmMinutos;

        String valorFormatado = FormatacaoNumero.FormatarDecimal(velocidadeKmPorH, 2);

        System.out.println("Seu pace de " + pace + " equivale a " + valorFormatado + " km/h");
    }

    public static void PaceNatacao() {

        System.out.println("\nDescubra o seu pace na natacao");

        float distancia = InputHelper.readFloat("Informe a distancia em metros: ");
        String tempoTotal = InputHelper.readString("Informe o tempo total da duracao (ex: hora:minuto:segundo): ");

        String [] arrayString = tempoTotal.split(":");

        int horas = Integer.parseInt(arrayString[0]);
        int minutos = Integer.parseInt(arrayString[1]);
        int segundos = Integer.parseInt(arrayString[2]);

        float tempoTotalSegundos = (horas * 3600) + ((float)minutos * 60) + segundos;
        float blocosPorSegundo = tempoTotalSegundos / (distancia / 100);
        float blocosPorMinuto = blocosPorSegundo / 60;

        int tempHoras;
        int tempMinutos = (int) blocosPorMinuto;

        if (blocosPorMinuto >= 60) {
            tempHoras = (int) blocosPorMinuto / 60;
            tempMinutos = tempMinutos - (tempHoras*60);
        }

        int tempSegundos = (int) ((blocosPorMinuto - (int) blocosPorMinuto) * 60);

        String paceFormatado = tempMinutos + ":" + (tempSegundos >= 10 ? tempSegundos : "0" + tempSegundos);

        System.out.println("Seu pace e de -> " + paceFormatado + " min/100m");

    }
}
