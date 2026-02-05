package Estoque_Produtos;

import Estoque_Produtos.Service.InputHelper;
import Estoque_Produtos.View.AppView;

public class Main {

    public static void main(String[] args) {

        int opcao;

        do {
            AppView.mostrarMenuPrincipal();
            opcao = InputHelper.readInt("Escolha uma opcao: ");
            AppView.handlerMenuPrincipal(opcao);
        } while (opcao != 0);
    }
}
