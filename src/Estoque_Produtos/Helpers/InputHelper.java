package Estoque_Produtos.Helpers;

import Estoque_Produtos.Exceptions.ValidationException;
import Estoque_Produtos.Logs.LogUser;
import Estoque_Produtos.Logs.SystemLog;

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
                LogUser.logAtencao("Digite apenas numeros inteiros!!");
            }
        }
    }

    public static double readDouble(String frase) {

        while(true) {
            try {
                System.out.print(frase);
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                LogUser.logAtencao("Digite apenas numeros decimais!!");
            }

        }
    }

    public static String readValidName(String frase) {
        while (true) {
            try {
                String nome = readString(frase);
                return Entry_Validator.isNomeValido(nome);
            } catch (ValidationException e) {
                LogUser.logErro(e.getMessage());
                SystemLog.error(e.getMessage());
            }
        }
    }
}
