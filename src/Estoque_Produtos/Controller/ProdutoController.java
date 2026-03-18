package Estoque_Produtos.Controller;

import Agenda_Contatos.TabelaFormatada;
import Estoque_Produtos.Dados.DataHandler;
import Estoque_Produtos.Exceptions.BusinessException;
import Estoque_Produtos.Exceptions.NotFoundException;
import Estoque_Produtos.Exceptions.ValidationException;
import Estoque_Produtos.Helpers.CurrencyFormatter;
import Estoque_Produtos.Logs.SystemLog;
import Estoque_Produtos.Produto;
import Estoque_Produtos.Logs.LogUser;
import Estoque_Produtos.Service.ProdutoService;
import Estoque_Produtos.View.TabelaProdutos;

public class ProdutoController {

    ProdutoService produtoService;

    public ProdutoController() {
        this.produtoService = new ProdutoService();
    }

    private void executarAcaoSemRetornoTratandoExcecao(Runnable acao) {
        try {
            acao.run();
        } catch (ValidationException e) {
            LogUser.logAtencao(e.getMessage());
            SystemLog.warn(e.getMessage());
        } catch (NotFoundException e) {
            LogUser.logAtencao(e.getMessage());
            SystemLog.warn(e.getMessage());
        } catch (BusinessException e) {
            LogUser.logAtencao(e.getMessage());
            SystemLog.warn(e.getMessage());
        } catch (IllegalArgumentException e) {
           LogUser.logAtencao("Valor para categoria não é válido!!");
           SystemLog.warn("Valor informado para categoria inválido");
        } catch (RuntimeException e) {
            LogUser.logErro("Erro inesperado!!");
            SystemLog.error(e.getMessage());
        }
    }

    public void listarProdutos() {
        SystemLog.info("Listagem de produtos");
        //TabelaProdutos.tabelaProdutos(produtoService.getProdutos());
        TabelaFormatada.tabelaFormatadaForMap(produtoService.getProdutos());
    }

    public void cadastrarProduto(String sku, String nome, double preco, int quantidade, String categoria) {
        executarAcaoSemRetornoTratandoExcecao(() -> {
            produtoService.cadastrarProduto(new Produto(sku, nome, preco, quantidade, categoria));
            LogUser.logSucesso("Produto cadastrado com sucesso!!");
            SystemLog.info("Produto cadastrado com sucesso | sku=" + sku + " nome=" + nome + " preco=" + CurrencyFormatter.currencyFormatter(preco) + " quantInicial=" + quantidade);
        });
    }

    public void addEstoque(String key, int quantidadeAddEstoque) {
        executarAcaoSemRetornoTratandoExcecao(() -> {
            produtoService.addEstoque(key, quantidadeAddEstoque);
            LogUser.logSucesso("Estoque atualizado com sucesso!!");
            SystemLog.info("Entrada de estoque realizada | sku=" + key + " add=" + quantidadeAddEstoque);
        });
    }

    public void saidaEstoque(String key, int quantidadeSaidaEstoque) {
        executarAcaoSemRetornoTratandoExcecao(() -> {
            produtoService.saidaEstoque(key, quantidadeSaidaEstoque);
            LogUser.logSucesso("Estoque autalizado com sucesso!!");
            SystemLog.info("Saída de estoque realizada | sku=" + key + " remove=" + quantidadeSaidaEstoque);
        });
    }

    public void consultarProduto(String key) {
        executarAcaoSemRetornoTratandoExcecao(() -> {
            Produto produto = produtoService.findProdutoByKeyOrThrowNotFoundException(key);
            SystemLog.info("Consulta produto | sku=" + produto.getSku());
            System.out.println(produto.getProdutoFormatado());
        });
    }

    public void deletarProduto(String key) {
        executarAcaoSemRetornoTratandoExcecao(() -> {
            produtoService.deleteProduto(key);
            LogUser.logSucesso("Produto removido com sucesso!!");
            SystemLog.info("Produto removido | sku=" + key);
        });
    }

    public void consultarValorTotalEstoque() {
        double valorTotal = produtoService.consultarValorTotalEstoque();
        SystemLog.info("Cálculo total do estoque | total=" + String.format("%.2f",valorTotal) + " itens=" + produtoService.consultarQuantidadeTotalEstoque());
        System.out.printf("-> %.2f", valorTotal);
    }

    public void consultarValorMedioEstoque() {
        double valorMedio = produtoService.consultarValorMedioEstoque();
        SystemLog.info("Cálculo preço médio | media=" + String.format("%.2f", valorMedio) + " itens=" + produtoService.consultarQuantidadeTotalEstoque() );
        System.out.printf("-> %.2f", valorMedio);
    }

    public void consultarQuantidadeTotalEstoque() {
        int quantidadeTotal = produtoService.consultarQuantidadeTotalEstoque();
        SystemLog.info("Consulta total produtos em estoque | itens=" + quantidadeTotal);
        System.out.println("-> " + quantidadeTotal + " itens");
    }

    public void consultarQuantidadeProdutosCadastrados() {
        int quantidaeProdutosCadastrados = produtoService.consultarQuantidadeProdutosCadastrados();
        SystemLog.info("Consulta quantidade produtos cadastrados | produtos=" + quantidaeProdutosCadastrados);
        System.out.println("-> " + quantidaeProdutosCadastrados + " produtos");
    }

    public void exportarDadosCsv() {
        DataHandler.exportDataToCsvFile(produtoService.getProdutos());
    }

}
