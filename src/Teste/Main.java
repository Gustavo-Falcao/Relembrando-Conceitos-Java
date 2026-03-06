package Teste;

import Agenda_Contatos.Contato;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        double moedaDouble = 1499;
        //String moedaFormatada = "R$ 20,90";

        Locale localPtbr = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localPtbr);

        BigDecimal bigDecimal = BigDecimal.valueOf(moedaDouble).setScale(2, RoundingMode.HALF_UP);

        String moedaFormatada = numberFormat.format(bigDecimal).replace('\u00A0', ' ');

        String soValor = moedaFormatada.replaceAll("[^0-9//,]+", "");
        String soValorPdouble = soValor.replace(",", ".");

        System.out.println("Moeda formatada ->" + moedaFormatada);
        System.out.println("Moeda so valor ->" + soValorPdouble);

        double valorPdouble = Double.parseDouble(soValorPdouble);

        System.out.printf("Valor so double -> %.2f", valorPdouble);

        //double preco = Double.parseDouble(moedaFormatada.replace("R$", ""));
    }
}
