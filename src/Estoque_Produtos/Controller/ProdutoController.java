package Estoque_Produtos.Controller;

import Estoque_Produtos.Exceptions.ValidationException;
import Estoque_Produtos.Helpers.SystemLog;
import Estoque_Produtos.Produto;
import Estoque_Produtos.Helpers.Entry_Validator;
import Estoque_Produtos.Helpers.LogUser;
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

    public boolean cadastrarProduto(String sku, String nome, double preco, int quantidade) {
        try{
            produtoService.cadastrarProduto(new Produto(sku, nome, preco, quantidade));
        } catch (ValidationException e) {
            LogUser.logAtencao("Erro ao cadastrar produto!!");
            SystemLog.warn(e.getMessage());
        }
        return true;
    }

    public void addEstoque(String key, int quantidadeAddEstoque) {
        //Tirar
        if(Entry_Validator.isQuantidadeEntradaValido(quantidadeAddEstoque)) {
            produtoService.addEstoque(key, quantidadeAddEstoque);
       } else {
           LogUser.logErro("Valor inválido para entrada de estoque!!");
          //LogUser.logHistorico("Tentativa de entrada de estoque sem sucesso - [entrada inválida]");
       }
    }

    public void saidaEstoque(String key, int quantidadeSaidaEstoque) {
        //Tirar
        if(Entry_Validator.isQuantidadeSaidaValido(quantidadeSaidaEstoque)) {
            produtoService.saidaEstoque(key, quantidadeSaidaEstoque);
        } else {
            LogUser.logErro("Valor inválido para a saida de estoque!!");
            //LogUser.logHistorico("Tentativa de saida de estoque sem sucesso - [saida inválida]");
        }
    }

    public Optional<Produto> consultarProduto(String key) {
        return produtoService.findProdutoByKey(key);
    }

    public void deletarProduto(String key) {
        produtoService.deleteProduto(key);
    }

    public double consultarValorTotalEstoque() {
        //Fazer conta no service
        double precoTotalEstoque = 0.0;

        for(Produto produto : produtoService.getProdutos().values()) {
            precoTotalEstoque += produto.getPreco();
        }

        return precoTotalEstoque;
    }

    public double consultarValorMedioEstoque() {
        //Fazer conta no service
        return consultarValorTotalEstoque() / produtoService.getProdutos().size();
    }

    public int consultarQuantidadeTotalEstoque() {
        return produtoService.getProdutos().size();
    }

}
