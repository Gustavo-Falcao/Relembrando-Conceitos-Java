package Manipulando_JSON_File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String caminhoArquivo = "src/Manipulando_JSON_File/pessoas.json";

    public static List<Pessoa> pessoas = carregarPessoasDoJsonFile();

//    public static List<Pessoa> pessoas = new ArrayList<>(List.of(
//            new Pessoa("Geferson da Silva", "(41) 99123-4501", "geferson.silva@example.com"),
//            new Pessoa("Maria Eduarda Souza", "(11) 99654-7821", "maria.eduarda.souza@example.com"),
//            new Pessoa("João Pedro Almeida", "(21) 99801-2245", "joao.pedro.almeida@example.com"),
//            new Pessoa("Ana Carolina Ribeiro", "(31) 98540-1123", "ana.carolina.ribeiro@example.com"),
//            new Pessoa("Lucas Martins", "(51) 99770-3344", "lucas.martins@example.com"),
//            new Pessoa("Beatriz Ferreira", "(19) 99412-7788", "beatriz.ferreira@example.com"),
//            new Pessoa("Rafael Lima", "(85) 98876-9021", "rafael.lima@example.com"),
//            new Pessoa("Camila Rocha", "(71) 98745-1256", "camila.rocha@example.com"),
//            new Pessoa("Pedro Henrique Castro", "(41) 99222-4477", "pedro.henrique.castro@example.com"),
//            new Pessoa("Larissa Oliveira", "(62) 99660-3311", "larissa.oliveira@example.com"),
//            new Pessoa("Felipe Araújo", "(11) 98111-2233", "larissa.oliveira@example.com"),
//            new Pessoa("Carolina Mendes", "(27) 99921-8899", "carolina.mendes@example.com"),
//            new Pessoa("Thiago Santos", "(81) 98770-6644", "thiago.santos@example.com"),
//            new Pessoa("Aline Barros", "(48) 99612-5566", "aline.barros@example.com"),
//            new Pessoa("Bruno Xavier", "(21) 98234-7788", "bruno.xavier@example.com"),
//            new Pessoa("Patrícia Nogueira", "(31) 98444-9090", "patricia.nogueira@example.com"),
//            new Pessoa("Diego Fernandes", "(67) 99110-3344", "diego.fernandes@example.com"),
//            new Pessoa("Juliana Pires", "(16) 99740-2211", "juliana.pires@example.com"),
//            new Pessoa("Mateus Correia", "(98) 98765-4433", "mateus.correia@example.com"),
//            new Pessoa("Isabela Martins", "(41) 99555-8811", "isabela.martins@example.com")
//    ));

    public static void main(String[] args) {
        for(Pessoa p : pessoas) {
            System.out.println(p.getPessoaFormatado());
            System.out.println();
        }

        System.out.println("Tamanho array => " + pessoas.size());
        System.out.println("Inserindo dados no arquivo...");
        inserirPessoasJsonFile(pessoas);
    }

    public static void inserirPessoasJsonFile(List<Pessoa> pessoas) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File(caminhoArquivo), pessoas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Pessoa> carregarPessoasDoJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();

        File arquivo = new File(caminhoArquivo);
        if(!arquivo.exists()) return new ArrayList<>();

        try {
            System.out.println("Entrou no try");
             return objectMapper.readValue(arquivo, new TypeReference<ArrayList<Pessoa>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
