package Manipulando_JSON_File.Model;

public class City {

    private String id;
    private String nome;
    private String sigla;
    private String distrito;
    private int populacao;

    public City() {}

    public City(int populacao, String distrito, String sigla, String nome, String id) {
        this.populacao = populacao;
        this.distrito = distrito;
        this.sigla = sigla;
        this.nome = nome;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
}
