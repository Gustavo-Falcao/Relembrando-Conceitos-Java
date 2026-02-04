package Teste;

import java.util.UUID;

public class Pessoa {

    private final String id;
    private String nome;
    private String telefone;
    private String email;

    public Pessoa (String nome, String telefone, String email) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPessoaFormatado() {
        return
                "\nId: " + id +
                        "\nNome: " + nome +
                        "\nTelefone: " + telefone +
                        "\nEmail: " + email;

    }
}
