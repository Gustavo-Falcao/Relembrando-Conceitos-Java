package Estoque_Produtos.View;

import Estoque_Produtos.Controller.ProdutoController;
import Estoque_Produtos.Produto;
import Estoque_Produtos.Helpers.InputHelper;
import Estoque_Produtos.Helpers.Log;

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

        produtoController.consultarProduto(key)
                .ifPresentOrElse(produto -> System.out.println(produto.getProdutoFormatado()),
                        () -> {
                                Log.logErro("Produto não encontrado");
                                Log.logHistorico("Tentativa de consulta de produto sem sucesso - [SKU inválido]");
                        }
                );
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
        double precoTotalEstoque = produtoController.consultarValorTotalEstoque();

        if(precoTotalEstoque < 0) {
            Log.logErro("Nenhum produto cadastrado ainda!!");
            Log.logHistorico("Tentativa de calculo de estoque sem sucesso - [nenhum produto cadastrado]");
        } else {
            System.out.printf("-> %.2f", precoTotalEstoque);
        }
    }

    public static void consultarValorMedioEstoque() {
        System.out.println("\n\n");
        System.out.println("<< Valor Medio Estoque >>");
        double precoMedioEstoque = produtoController.consultarValorMedioEstoque();

        if(precoMedioEstoque < 0) {
            Log.logErro("Nenhum produto cadastrado ainda!!");
            System.out.printf("Valor aqui -> %.2f", precoMedioEstoque);
            Log.logHistorico("Tentativa de calculo de estoque sem sucesso - [nenhum produto cadastrado]");
        } else {
            System.out.printf("-> %.2f", precoMedioEstoque);
        }
    }

    public static void consultarQuantidadeTotalEstoque() {
        System.out.println("\n\n");
        System.out.println("<< Quantidade Total Estoque >>");
        System.out.println("-> " + produtoController.consultarQuantidadeTotalEstoque());
    }
}

