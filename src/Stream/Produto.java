package Stream;

public class Produto {

    private int id;
    private String nome;
    private String categoria;
    private double preco;
    private int estoque;
    private boolean ativo;
    private String marca;

    public Produto(){}

    public Produto(int id, String nome, String categoria, double preco, int estoque, boolean ativo, String marca) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.estoque = estoque;
        this.ativo = ativo;
        this.marca = marca;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "{Id: " + id +
                "; Nome: " + nome +
                "; Categoria: " + categoria +
                "; Preco: " + preco +
                "; Estoque: " + estoque +
                "; Ativo: " + ativo +
                "; Marca: " + marca +
                "}";
    }
}

