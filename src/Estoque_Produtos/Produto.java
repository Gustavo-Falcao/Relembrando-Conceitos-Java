package Estoque_Produtos;

public class Produto {

    private String sku;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String sku, String nome, double preco, int quantidade) {
        this.sku = sku;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
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

    public String getProdutoFormatado() {
        return "\nSKU -> " + this.sku +
                "\nNome -> " + this.nome +
                "\nPreco -> " + this.preco +
                "\nQuantidade -> " + this.quantidade;
    }
}
