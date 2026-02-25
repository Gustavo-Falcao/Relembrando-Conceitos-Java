package Estoque_Produtos.Helpers;

import java.util.Scanner;

public class InputHelper {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String frase) {
        System.out.print(frase);
        return scanner.nextLine();
    }

    public static int readInt(String frase) {
        while (true) {
            try {
                System.out.print(frase);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                Log.logAtencao("Digite apenas numeros inteiros!!");
            }
        }
    }

    public static double readDouble(String frase) {

        while(true) {
            try {
                System.out.print(frase);
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                Log.logAtencao("Digite apenas numeros decimais!!");
            }

        }
    }
}
