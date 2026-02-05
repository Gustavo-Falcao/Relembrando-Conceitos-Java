package Estoque_Produtos.View;

import Estoque_Produtos.Controller.ProdutoController;
import Estoque_Produtos.Produto;
import Estoque_Produtos.Service.InputHelper;
import Estoque_Produtos.Service.Log;

public class ProdutoView {

    public static ProdutoController produtoController = new ProdutoController();

    public static void cadastrarProduto() {
        System.out.println("\n\n");
        System.out.println("<<Cadastrar produto>>");

        String sku = InputHelper.readString("Informe o codigo do produto: ");
        String nome = InputHelper.readString("Informe o nome do produto: ");
        double preco = InputHelper.readDouble("Informe o preco do produto: ");
        int quantidade = InputHelper.readInt("Informe a quantidade inicial de estoque: ");

        if(produtoController.cadastrarProduto(sku, nome, preco, quantidade)) Log.logSucesso("Produto cadastrado!!");
    }

    public static void mostrarProdutos() {
        var produtos = produtoController.getProdutos();

        System.out.println("\n\n");
        for(Produto produto : produtos.values()) {
            System.out.println(produto.getProdutoFormatado());
        }
    }
}
