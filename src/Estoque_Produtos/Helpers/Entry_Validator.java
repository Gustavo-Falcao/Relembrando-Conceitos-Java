package Estoque_Produtos.Helpers;

import Estoque_Produtos.Produto;

import java.util.Map;

public class Entry_Validator {

    public static boolean isEmailValido(String email) {
        //validar email
        return true;
    }

    public static boolean isSkuRepetido(String sku, Map<String, Produto> produtos) {
        return produtos.containsKey(sku);
    }

    public static boolean isNomeValido(String nome) {
        String nomePuro = nome.trim();

        if(nomePuro.length() < 2 || nomePuro.length() > 60) return false;

        if(!nome.matches(".*\\p{L}.*")) return false;

        return true;
    }
    public static boolean isPrecoEntradaValido(double preco) {
        return preco > 0;
    }
    public static boolean isQuantidadeEntradaValido(int quantidaDeEntrada) {
        return quantidaDeEntrada > 0;
    }

    public static boolean isQuantidadeSaidaValido(int quantidadeSaida) {
        return quantidadeSaida > 0;
    }


}
