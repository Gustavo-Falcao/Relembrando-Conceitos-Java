package Estoque_Produtos.View;

import Estoque_Produtos.Controller.ProdutoController;
import Estoque_Produtos.Helpers.InputHelper;

public class ProdutoView {

    public static ProdutoController produtoController = new ProdutoController();


    public static void cadastrarProduto() {
        System.out.println("\n\n");
        System.out.println("<<Cadastrar produto>>");

        String sku = InputHelper.readString("Informe o codigo do produto: ");
        String nome = InputHelper.readValidName("Informe o nome do produto: ");
        double preco = InputHelper.readDouble("Informe o preco do produto: ");
        int quantidade = InputHelper.readInt("Informe a quantidade inicial de estoque: ");

        produtoController.cadastrarProduto(sku, nome, preco, quantidade);
    }

    public static void mostrarProdutos() {
        System.out.println("\n\n");
        produtoController.listarProdutos();
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

        produtoController.consultarProduto(key);
    }

    public static void deletarProduto() {
        System.out.println("\n\n");
        System.out.println("<< Deletar Produto >>");
        String key = InputHelper.readString("Informe o código do produto: ");

        produtoController.deletarProduto(key);
    }

    public static void consultarValorTotalEstoque() {
        System.out.println("\n\n");
        System.out.println("<< Valor Total Estoque >>");

        produtoController.consultarValorTotalEstoque();
    }

    public static void consultarValorMedioEstoque() {
        System.out.println("\n\n");
        System.out.println("<< Valor Medio Estoque >>");

        produtoController.consultarValorMedioEstoque();
    }

    public static void consultarQuantidadeTotalEstoque() {
        System.out.println("\n\n");
        System.out.println("<< Quantidade Total Estoque >>");

        produtoController.consultarQuantidadeTotalEstoque();
    }

    public static void consultarQuantidadeProdutosCadastrados() {
        System.out.println("\n\n");
        System.out.println("<< Quantidade produtos cadastrados >>");

        produtoController.consultarQuantidadeProdutosCadastrados();
    }
}

