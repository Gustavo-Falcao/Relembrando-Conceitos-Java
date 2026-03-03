package Estoque_Produtos.Controller;

import Estoque_Produtos.Exceptions.BusinessException;
import Estoque_Produtos.Exceptions.NotFoundException;
import Estoque_Produtos.Exceptions.ValidationException;
import Estoque_Produtos.Helpers.CurrencyFormatter;
import Estoque_Produtos.Logs.SystemLog;
import Estoque_Produtos.Produto;
import Estoque_Produtos.Logs.LogUser;
import Estoque_Produtos.Service.ProdutoService;

import java.util.Map;
import java.util.Optional;

public class ProdutoController {

    ProdutoService produtoService;

    public ProdutoController() {
        this.produtoService = new ProdutoService();
    }

    public Map<String, Produto> getProdutos() {
        return  produtoService.getProdutos();
    }

    public void cadastrarProduto(String sku, String nome, double preco, int quantidade) {
        try {
            produtoService.cadastrarProduto(new Produto(sku, nome, preco, quantidade));
            LogUser.logSucesso("Produto cadastrado com sucesso!!");
            SystemLog.info("Produto cadastrado com sucesso | sku=" + sku + " nome=" + nome + " preco=" + CurrencyFormatter.currencyFormatter(preco, 2) + " quantInicial=" + quantidade);
        } catch (ValidationException e) {
            LogUser.logAtencao("Erro ao cadastrar produto!!");
            SystemLog.warn(e.getMessage());
        }
    }

    public void addEstoque(String key, int quantidadeAddEstoque) {
        try {
            produtoService.addEstoque(key, quantidadeAddEstoque);
            LogUser.logSucesso("Estoque atualizado com sucesso!!");
            SystemLog.info("Entrada de estoque realizada | sku=" + key + " add=" + quantidadeAddEstoque);
        } catch (NotFoundException e) {
            LogUser.logAtencao("Produto não encontrado!!");
            SystemLog.warn(e.getMessage());
        } catch (ValidationException e) {
            LogUser.logAtencao("Entrada inválida para estoque!!");
            SystemLog.warn(e.getMessage());
        }
    }

    public void saidaEstoque(String key, int quantidadeSaidaEstoque) {
        try {
            produtoService.saidaEstoque(key, quantidadeSaidaEstoque);
            LogUser.logSucesso("Estoque autalizado com sucesso!!");
            SystemLog.info("Saída de estoque realizada | sku=" + key + " remove=" + quantidadeSaidaEstoque);
        } catch (NotFoundException e) {
            LogUser.logAtencao("Produto não encontrado!!");
            SystemLog.warn(e.getMessage());
        } catch (ValidationException e) {
            LogUser.logAtencao("Quantidade de entrada inválida!!");
            SystemLog.warn(e.getMessage());
        } catch (BusinessException e) {
            LogUser.logAtencao("Estoque insuficiente!!");
            SystemLog.warn(e.getMessage());
        }
    }

    public Produto consultarProdutoOrNotFoundException(String key) {
        return produtoService.findProdutoByKeyOrThrowNotFoundException(key);
    }

    public void deletarProduto(String key) {
        try {
            produtoService.deleteProduto(key);
            LogUser.logSucesso("Produto removido com sucesso!!");
            SystemLog.info("Produto removido | sku=" + key);
        }catch (NotFoundException e) {
            LogUser.logErro("Produto não encontrado!!");
            SystemLog.warn(e.getMessage());
        }
    }

    public double consultarValorTotalEstoque() {
        return produtoService.consultarValorTotalEstoque();
    }

    public double consultarValorMedioEstoque() {
        return produtoService.consultarValorMedioEstoque();

    }

    public int consultarQuantidadeTotalEstoque() {
        return produtoService.consultarQuantidadeTotalEstoque();
    }

}
