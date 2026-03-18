package Teste;

import Agenda_Contatos.Contato;
import Agenda_Contatos.TabelaFormatada;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println(contarDigitosUnicos(12345)); // 5
        System.out.println(contarDigitosUnicos(11111)); // 1
        System.out.println(contarDigitosUnicos(987789)); // 4


    }
    public static int contarDigitosUnicos(int num) {
        // Seu código aqui
        String numeroToString = String.valueOf(num);
        Set<Character> numerosUnicos = new HashSet<>();

        for(int i = 0; i < numeroToString.length(); i++) {
            numerosUnicos.add(numeroToString.charAt(i));
        }
        // Dica: converta o número para String e use um Set para contar dígitos únicos
        return numerosUnicos.size();
    }
}
