package Teste;

import Agenda_Contatos.Contato;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        String moedaFormatada = "R$ 20,90";

        String soValor = moedaFormatada.replace("R$\s", "");
        String soValorPdouble = soValor.replace(",", ".");

        System.out.println("Moeda formatada ->" + moedaFormatada);
        System.out.println("Moeda so valor ->" + soValorPdouble);

        double valorPdouble = Double.parseDouble(soValorPdouble);

        System.out.printf("Valor so double -> %.2f", valorPdouble);

        //double preco = Double.parseDouble(moedaFormatada.replace("R$", ""));
    }
}
