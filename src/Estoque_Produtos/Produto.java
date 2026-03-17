package Estoque_Produtos;

import Estoque_Produtos.Enums.Categoria;

public class Produto {

    private String sku;
    private String nome;
    private double preco;
    private int quantidade;
    private Categoria categoria;

    public Produto(String sku, String nome, double preco, int quantidade, String categoria) {
        this.sku = sku;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = Categoria.valueOf(categoria);
    }

    public String getSku() {
        return sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = Categoria.valueOf(categoria);
    }

    public String getProdutoFormatado() {
        return "\nSKU -> " + this.sku +
                "\nNome -> " + this.nome +
                "\nPreco -> " + this.preco +
                "\nQuantidade -> " + this.quantidade;
    }
}
