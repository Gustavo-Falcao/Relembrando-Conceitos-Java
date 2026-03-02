package Estoque_Produtos.Helpers;

import Estoque_Produtos.Exceptions.*;

public class Entry_Validator {

    public static String isNomeValido(String nome) {
        String nomePuro = nome.trim();

        if(nomePuro.length() < 2 || nomePuro.length() > 60) throw new ValidationException("Entrada inválida para nome");

        if(!nomePuro.matches(".*\\p{L}.*")) throw new ValidationException("Entrada inválida para nome");

        return nomePuro;
    }

    public static boolean isQuantidadeSaidaValido(int quantidadeSaida) {
        return quantidadeSaida > 0;
    }

}
