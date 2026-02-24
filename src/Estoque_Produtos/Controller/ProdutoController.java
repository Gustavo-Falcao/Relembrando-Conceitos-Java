package Estoque_Produtos.Controller;

import Estoque_Produtos.Produto;
import Estoque_Produtos.Service.Entry_Validator;
import Estoque_Produtos.Service.Log;
import Estoque_Produtos.Service.ProdutoService;

import java.util.HashMap;
import java.util.Map;

public class ProdutoController {

    ProdutoService produtoService;

    public ProdutoController() {
        this.produtoService = new ProdutoService();
    }

    public Map<String, Produto> getProdutos() {
        return  produtoService.getProdutos();
    }

    public boolean cadastrarProduto(String sku, String nome, double preco, int quantidade) {
        Map<String,Produto> produtos = produtoService.getProdutos();

        //Verificando se o codigo do produto informado ja existe
        if(Entry_Validator.isSkuRepetido(sku, produtos)) {
            Log.logErro("Codigo do produto informado já está cadastrado!!");
            return false;
        }

        if(!Entry_Validator.isNomeValido(nome)) {
            Log.logErro("Valor inválido para o nome do produto!!");
            return false;
        }

        if(!Entry_Validator.isPrecoEntradaValido(preco)) {
            Log.logErro("Valor do preco invalido!!");
            return false;
        }
        if(!Entry_Validator.isQuantidadeEntradaValido(quantidade)) {
            Log.logErro("Valor inválido para entrada de estoque!!");
            return false;
        }

        produtoService.cadastrarProduto(new Produto(sku, nome, preco, quantidade));
        return true;
    }

    public void addEstoque(String key, int quantidadeAddEstoque) {
       if(Entry_Validator.isQuantidadeEntradaValido(quantidadeAddEstoque)) {
            produtoService.addEstoque(key, quantidadeAddEstoque);
       } else {
           Log.logErro("Valor inválido para entrada de estoque!!");
       }
    }

    public void saidaEstoque(String key, int quantidadeSaidaEstoque) {
        if(Entry_Validator.isQuantidadeSaidaValido(quantidadeSaidaEstoque)) {
            produtoService.saidaEstoque(key, quantidadeSaidaEstoque);
        } else {
            Log.logErro("Valor inválido para a saida de estoque!!");
        }
    }

    public Produto consultarProduto(String key) {
        return produtoService.findProdutoByKey(key).orElse(null);
    }

}
