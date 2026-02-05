package Estoque_Produtos.View;

import Estoque_Produtos.Service.Log;

public class AppView {

    public static void mostrarMenuPrincipal() {
        System.out.println("\n\n+ --------------------------------------- +");
        System.out.println("|        [1] - Cadastrar produto          |");
        System.out.println("|        [2] - Entrada de estoque         |");
        System.out.println("|        [3] - Saida de estoque           |");
        System.out.println("|        [4] - Consultar produto          |");
        System.out.println("|        [5] - Listar todos os produtos   |");
        System.out.println("|        [6] - Remover produto            |");
        System.out.println("|        [0] - Sair                       |");
        System.out.println("+ --------------------------------------- +");
    }

    public static void handlerMenuPrincipal(int opcao) {
        switch (opcao) {
            case 1 -> ProdutoView.cadastrarProduto();
            case 5 -> ProdutoView.mostrarProdutos();
            case 0 -> System.out.println("Saindo...");
            default -> Log.logAtencao("Escolha uma opcao valida!!");
        }
    }
}
