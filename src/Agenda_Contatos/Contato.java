package Agenda_Contatos;

import java.util.UUID;

public class Contato {

    private final String id;
    private String nome;
    private String telefone;
    private String email;

    public Contato (String nome, String telefone, String email) {
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

    public String getContatoFormatado() {
        return
                "\nId: " + id +
                "\nNome: " + nome +
                "\nTelefone: " + telefone +
                "\nEmail: " + email;

    }

    @Override
    public String toString() {
        return "Contato{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
