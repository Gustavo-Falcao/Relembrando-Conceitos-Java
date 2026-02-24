package Estoque_Produtos.View;

import Estoque_Produtos.Controller.ProdutoController;
import Estoque_Produtos.Produto;
import Estoque_Produtos.Service.InputHelper;
import Estoque_Produtos.Service.Log;

import java.security.PublicKey;

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
        System.out.println("\n\n");
        TabelaProdutos.tabelaProdutos(produtoController.getProdutos());
    }

    public static void addEstoque() {
        System.out.println("\n\n");
        System.out.println("<< Adicionar Estoque >>");
        String key = InputHelper.readString("Informe o código do produto: ");
        int quantidadeEntrada = InputHelper.readInt("Informe a quantidade de produtos: ");
        produtoController.addEstoque(key, quantidadeEntrada);
    }

    public static void saidaEstoque() {
        System.out.println("\n\n");
        System.out.println("<< Saida de Estoque >>");
        String key = InputHelper.readString("Informe o código do produto: ");
        int quantidadeSaida = InputHelper.readInt("Informe a quantidade de produtos: ");
        produtoController.saidaEstoque(key, quantidadeSaida);
    }

    public static void consultarProduto() {
        System.out.println("\n\n");
        System.out.println("<< Consultar Produto >>");
        String key = InputHelper.readString("Informe o código do produto: ");

        Produto produto = produtoController.consultarProduto(key);
        if(produto != null) {
            System.out.println(produto.getProdutoFormatado());
        } else {
            Log.logErro("Produto não encontrado!!");
        }

    }
}
