package Teste;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Digite um valor: ");
        double valor = Double.parseDouble(reader.nextLine());

        int valorInteiro = (int) valor;

        double decimal = valor - valorInteiro;

        //DecimalFormat formatter = new DecimalFormat("0.00");

        //System.out.println("Valor decimal formatado com o formatter => " + formatter.format(decimal));

        //double decimalFormatted = Double.parseDouble(formatter.format(decimal));

        int value = (int)(decimal * 60);

        System.out.println("Decimal formatado abaixo");
        //System.out.println((int)(decimalFormatted*100));
        System.out.println("Valor aqui => " + value);
        System.out.println("Pace => " + valorInteiro + ":" + value);

        //System.out.printf("Valor decimal %.2f%n", decimal);

        //System.out.println(formatter.format(decimal));
    }
}
