package Manipulando_JSON_File.Model;

public class Country {

    private String codigo;
    private String nome;
    private String continente;
    private String regiao;
    private float area;
    private int anoIndependencia;
    private int populacaoTotal;
    private float expectativaVida;
    private float pibUsd;
    private String nomeNativo;
    private String formaGoverno;
    private String lider;
    private String capitalId;

    public Country() {}

    public Country(String codigo, String nome, String continente, String regiao, float area, int anoIndependencia, int populacaoTotal, float expectativaVida, float pibUsd, String nomeNativo, String formaGoverno, String lider, String capitalId) {
        this.codigo = codigo;
        this.nome = nome;
        this.continente = continente;
        this.regiao = regiao;
        this.area = area;
        this.anoIndependencia = anoIndependencia;
        this.populacaoTotal = populacaoTotal;
        this.expectativaVida = expectativaVida;
        this.pibUsd = pibUsd;
        this.nomeNativo = nomeNativo;
        this.formaGoverno = formaGoverno;
        this.lider = lider;
        this.capitalId = capitalId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getAnoIndependencia() {
        return anoIndependencia;
    }

    public void setAnoIndependencia(int anoIndependencia) {
        this.anoIndependencia = anoIndependencia;
    }

    public int getPopulacaoTotal() {
        return populacaoTotal;
    }

    public void setPopulacaoTotal(int populacaoTotal) {
        this.populacaoTotal = populacaoTotal;
    }

    public float getExpectativaVida() {
        return expectativaVida;
    }

    public void setExpectativaVida(float expectativaVida) {
        this.expectativaVida = expectativaVida;
    }

    public float getPibUsd() {
        return pibUsd;
    }

    public void setPibUsd(float pibUsd) {
        this.pibUsd = pibUsd;
    }

    public String getNomeNativo() {
        return nomeNativo;
    }

    public void setNomeNativo(String nomeNativo) {
        this.nomeNativo = nomeNativo;
    }

    public String getFormaGoverno() {
        return formaGoverno;
    }

    public void setFormaGoverno(String formaGoverno) {
        this.formaGoverno = formaGoverno;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public String getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(String capitalId) {
        this.capitalId = capitalId;
    }
}
