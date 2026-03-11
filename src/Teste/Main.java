package Teste;

import Agenda_Contatos.Contato;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Class <?> classe = Pessoa.class;
        Method[] metodos = classe.getDeclaredMethods();
        Field[] campos = classe.getDeclaredFields();

        System.out.println("Nome classe => " + classe.getSimpleName());

        for(Method method : metodos) {
            System.out.println(method.getName());
        }

        System.out.println();
        for(Field field : campos) {
            System.out.println("Nome campo => " + field.getName());
            System.out.println("Nome tipo retorno => " + field.getType().getSimpleName());
        }

        try {
            Method method = classe.getMethod("getNome");

            Pessoa p = new Pessoa("Gustavo", "923231119", "gustavo@gmail.com");

            Object result = method.invoke(p);

            String resultToString = (String) result;
            System.out.println();
            System.out.println(resultToString);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
