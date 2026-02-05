package Estoque_Produtos.Controller;

import Estoque_Produtos.Produto;
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
        if(produtos.containsKey(sku)) {
            Log.logErro("Codigo do produto informado ja esta cadastrado!!");
            return false;
        }

        if(preco < 0) {
            Log.logErro("Valor do preco invalido!!");
            return false;
        }

        if(quantidade < 0) {
            Log.logErro("Quantidade de estoque invalida");
            return false;
        }

        produtoService.cadastrarProduto(new Produto(sku, nome, preco, quantidade));
        return true;
    }
}
