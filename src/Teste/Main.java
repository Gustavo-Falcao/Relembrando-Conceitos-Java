package Teste;

import Agenda_Contatos.Contato;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>(List.of(
                new Pessoa("Geferson da Silva", "(41) 99123-4501", "geferson.silva@example.com"),
                new Pessoa("Maria Eduarda Souza", "(11) 99654-7821", "maria.eduarda.souza@example.com"),
                new Pessoa("João Pedro Almeida", "(21) 99801-2245", "joao.pedro.almeida@example.com"),
                new Pessoa("Ana Carolina Ribeiro", "(31) 98540-1123", "ana.carolina.ribeiro@example.com"),
                new Pessoa("Lucas Martins", "(51) 99770-3344", "lucas.martins@example.com"),
                new Pessoa("Beatriz Ferreira", "(19) 99412-7788", "beatriz.ferreira@example.com"),
                new Pessoa("Rafael Lima", "(85) 98876-9021", "rafael.lima@example.com"),
                new Pessoa("Camila Rocha", "(71) 98745-1256", "camila.rocha@example.com"),
                new Pessoa("Pedro Henrique Castro", "(41) 99222-4477", "pedro.henrique.castro@example.com"),
                new Pessoa("Larissa Oliveira", "(62) 99660-3311", "larissa.oliveira@example.com")
        ));

        for(Pessoa p : pessoas) {
            System.out.println(p.getPessoaFormatado());
        }

        System.out.print("\nDigigite um id: ");
        String idBusca = reader.nextLine();

        Pessoa pessoa = pessoas.stream()
                .filter(p -> p.getId().contains(idBusca))
                .findFirst()
                .orElse(null);

        System.out.println("\n\nResultado aqui -> " + (pessoa == null ? "Pessoa nao encontrada" : pessoa.getPessoaFormatado()));
        System.out.println("Quantidade carecter id digitado sem trim => " + idBusca.length());
        System.out.println("Quantidade carecter id digitado com trim => " + idBusca.trim().length());
        System.out.println("Condição 202.77 é maior que 0 ? -> " + (202.77 > 0));
    }
}
