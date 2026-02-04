package Agenda_Contatos;

import java.util.Scanner;

public class InputHelper {

    public static String readString(String frase) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(frase);
        return  scanner.nextLine();
    }

    public static int readInteger(String frase) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try{
                System.out.print(frase);
                return Integer.parseInt(scanner.nextLine());
            }catch (Exception e) {
                System.out.println("Digite apenas numeros inteiros!!");
            }
        }
    }
}
