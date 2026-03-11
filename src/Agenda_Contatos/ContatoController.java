package Agenda_Contatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ContatoController {

    private List<Contato> contatos;

    public ContatoController() {
        this.contatos = new ArrayList<>(List.of(
                new Contato("Geferson da Silva", "(41) 99123-4501", "geferson.silva@example.com"),
                new Contato("Maria Eduarda Souza", "(11) 99654-7821", "maria.eduarda.souza@example.com"),
                new Contato("João Pedro Almeida", "(21) 99801-2245", "joao.pedro.almeida@example.com"),
                new Contato("Ana Carolina Ribeiro", "(31) 98540-1123", "ana.carolina.ribeiro@example.com"),
                new Contato("Lucas Martins", "(51) 99770-3344", "lucas.martins@example.com"),
                new Contato("Beatriz Ferreira", "(19) 99412-7788", "beatriz.ferreira@example.com"),
                new Contato("Rafael Lima", "(85) 98876-9021", "rafael.lima@example.com"),
                new Contato("Camila Rocha", "(71) 98745-1256", "camila.rocha@example.com"),
                new Contato("Pedro Henrique Castro", "(41) 99222-4477", "pedro.henrique.castro@example.com"),
                new Contato("Larissa Oliveira", "(62) 99660-3311", "larissa.oliveira@example.com"),
                new Contato("Felipe Araújo", "(11) 98111-2233", "larissa.oliveira@example.com"),
                new Contato("Carolina Mendes", "(27) 99921-8899", "carolina.mendes@example.com"),
                new Contato("Thiago Santos", "(81) 98770-6644", "thiago.santos@example.com"),
                new Contato("Aline Barros", "(48) 99612-5566", "aline.barros@example.com"),
                new Contato("Bruno Xavier", "(21) 98234-7788", "bruno.xavier@example.com"),
                new Contato("Patrícia Nogueira", "(31) 98444-9090", "patricia.nogueira@example.com"),
                new Contato("Diego Fernandes", "(67) 99110-3344", "diego.fernandes@example.com"),
                new Contato("Juliana Pires", "(16) 99740-2211", "juliana.pires@example.com"),
                new Contato("Mateus Correia", "(98) 98765-4433", "mateus.correia@example.com"),
                new Contato("Isabela Martins", "(41) 99555-8811", "isabela.martins@example.com")
        ));
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void mostrarContatos () {
        //TabelaFormatada.tabelaFormatada(getContatos());
    }

    public void criarContato() {
        System.out.println("\n\n<<Criar novo contato >>");

        String nome = InputHelper.readString("Informe o nome: ");
        String telefone = InputHelper.readString("Informe o telefone: ");
        String email = InputHelper.readString("Infome o email: ");

        contatos.add(new Contato(nome, telefone, email));

        System.out.println("\nContato criado com sucesso ✔️");
    }

    public void atualizarContato() {
        System.out.println("\n\n<<Atualizar Contato>>");

        String idConsulta = InputHelper.readString("Informe o id do contato: ");
        Contato contato = buscarContatoPorId(idConsulta).orElse(null);

        while (contato == null) {
            System.out.println("\n\nContato nao encontrado!!");
            idConsulta = InputHelper.readString("Informe o id do contato novamente: ");
            contato = buscarContatoPorId(idConsulta).orElse(null);
        }

        System.out.println("Contato encontrado!!");
        int opcaoAtualizacao;

        do {
            System.out.println("\n\n" + contato.getContatoFormatado());
            System.out.println("\n+ ------------------------------ +");
            System.out.println("|          [1] - Nome            |");
            System.out.println("|          [2] - Telefone        |");
            System.out.println("|          [3] - Email           |");
            System.out.println("|          [0] - Sair            |");
            System.out.println("+ ------------------------------ +");
            opcaoAtualizacao = InputHelper.readInteger("Escolha uma opcao para atualizar: ");

            handlerOpacaoAtualizar(opcaoAtualizacao, contato);

        } while (opcaoAtualizacao != 0);


    }

    private void handlerOpacaoAtualizar (int opcao, Contato contato) {
        switch (opcao) {
            case 1:
                System.out.println("\n\nAlterar nome");
                String nome = InputHelper.readString("Informe o novo nome para o contato: ");
                contato.setNome(nome);
                break;
            case 2:
                System.out.println("\n\nAlterar telefone");
                String telefone = InputHelper.readString("Informe o novo telefone: ");
                contato.setTelefone(telefone);
                break;
            case 3:
                System.out.println("\n\nAlterar email");
                String email = InputHelper.readString("Informe o novo email: ");
                contato.setEmail(email);
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Escolha uma opcao valida!!");
                break;
        }
    }

    public void deletarContato() {
        System.out.println("\n\n<<Deletar contato>>");
        String idContato = InputHelper.readString("Informe o id do contato: ");

        //buscarContatoPorId(idContato).ifPresent(this::apagarContato);

        Contato contato = buscarContatoPorId(idContato).orElse(null);

        if(contato != null) {
            apagarContato(contato);
            System.out.println("\nContato excluido com sucesso");
        } else {
            System.out.println("\nContato não encontrado!!");
        }

    }

    public void buscarContato() {
        System.out.println("\n\n<<Buscar contato>>");
        String idContato = InputHelper.readString("Informe o id do contato: ");

        Contato contato = buscarContatoPorId(idContato).orElse(null);

        if(contato != null) {
            System.out.println("\nContato encontrado!!");
            System.out.println("\n\n" + contato.getContatoFormatado());
        } else {
            System.out.println("\n Contato não encontrado ❌");
        }
    }

    private void apagarContato(Contato contato) {
        contatos.remove(contato);
    }


    private Optional<Contato> buscarContatoPorId(String idContato) {
        return contatos.stream()
                .filter(c -> c.getId().contains(idContato))
                .findFirst();
    }

}


//        {
//        "id": 21,
//        "nome": "Rodrigo Teixeira",
//        "email": "rodrigo.teixeira@example.com",
//        "telefone": "(11) 99123-8899",
//        "endereco": "Av. Faria Lima, 3477 - Itaim Bibi, São Paulo - SP"
//        },
//        {
//        "id": 22,
//        "nome": "Letícia Moraes",
//        "email": "leticia.moraes@example.com",
//        "telefone": "(31) 98880-1234",
//        "endereco": "Rua Padre Eustáquio, 220 - Padre Eustáquio, Belo Horizonte - MG"
//        },
//        {
//        "id": 23,
//        "nome": "André Barbosa",
//        "email": "andre.barbosa@example.com",
//        "telefone": "(85) 98666-7788",
//        "endereco": "Av. Dom Luís, 1400 - Aldeota, Fortaleza - CE"
//        },
//        {
//        "id": 24,
//        "nome": "Mariana Campos",
//        "email": "mariana.campos@example.com",
//        "telefone": "(71) 98111-7788",
//        "endereco": "Av. Tancredo Neves, 3000 - Caminho das Árvores, Salvador - BA"
//        },
//        {
//        "id": 25,
//        "nome": "Vitor Rezende",
//        "email": "vitor.rezende@example.com",
//        "telefone": "(21) 99777-5500",
//        "endereco": "Av. das Américas, 5000 - Barra da Tijuca, Rio de Janeiro - RJ"
//        },
//        {
//        "id": 26,
//        "nome": "Natália Queiroz",
//        "email": "natalia.queiroz@example.com",
//        "telefone": "(19) 99661-1144",
//        "endereco": "Av. José de Souza Campos, 120 - Cambuí, Campinas - SP"
//        },
//        {
//        "id": 27,
//        "nome": "Daniel Carvalho",
//        "email": "daniel.carvalho@example.com",
//        "telefone": "(51) 99500-6677",
//        "endereco": "Rua Padre Chagas, 250 - Moinhos de Vento, Porto Alegre - RS"
//        },
//        {
//        "id": 28,
//        "nome": "Bianca Silveira",
//        "email": "bianca.silveira@example.com",
//        "telefone": "(27) 99777-9988",
//        "endereco": "Rua Aleixo Netto, 800 - Praia do Canto, Vitória - ES"
//        },
//        {
//        "id": 29,
//        "nome": "Eduardo Paiva",
//        "email": "eduardo.paiva@example.com",
//        "telefone": "(62) 98412-3355",
//        "endereco": "Av. 85, 1900 - Setor Marista, Goiânia - GO"
//        },
//        {
//        "id": 30,
//        "nome": "Sabrina Tavares",
//        "email": "sabrina.tavares@example.com",
//        "telefone": "(48) 99888-2211",
//        "endereco": "Av. das Rendeiras, 600 - Lagoa da Conceição, Florianópolis - SC"
//        }