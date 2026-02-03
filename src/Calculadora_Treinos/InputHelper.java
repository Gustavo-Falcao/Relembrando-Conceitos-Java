package Calculadora_Treinos;

import java.util.Scanner;

public class InputHelper {

    static Scanner reader = new Scanner(System.in);

    public static int readInteger(String frase) {
        while (true) {
            try {
                System.out.print(frase);
                return  Integer.parseInt(reader.nextLine());
            }catch (Exception e) {
                System.out.println("Digite apenas numeros inteiros!\n");
            }
        }
    }

    public static double readDouble(String frase) {
        while (true) {
            try {
                System.out.print(frase);
                return  Double.parseDouble(reader.nextLine());
            }catch (Exception e) {
                System.out.println("Digite apenas numeros!\n");
            }
        }
    }

    public static String readString(String frase) {
        System.out.print(frase);
        return reader.nextLine();
    }


}
