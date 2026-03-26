package Stream;

import java.util.*;
import java.util.stream.Collectors;

import Agenda_Contatos.TabelaFormatada;

public class Main {

    private static List<Produto> produtos = List.of(
            new Produto(1, "Mouse Gamer", "Periféricos", 150.0, 10, true, "Logitech"),
            new Produto(2, "Teclado Mecânico", "Periféricos", 320.0, 5, true, "Redragon"),
            new Produto(3, "Monitor 24", "Monitores", 900.0, 3, true, "LG"),
            new Produto(4, "Monitor 27", "Monitores", 1200.0, 0, true, "Samsung"),
            new Produto(5, "Notebook i5", "Informática", 3500.0, 2, true, "Dell"),
            new Produto(6, "Notebook i7", "Informática", 5000.0, 1, false, "Lenovo"),
            new Produto(7, "Cadeira Gamer", "Móveis", 850.0, 4, true, "DT3"),
            new Produto(8, "Mesa Escrivaninha", "Móveis", 650.0, 6, true, "Kappesberg"),
            new Produto(9, "Headset Pro", "Periféricos", 280.0, 8, false, "HyperX"),
            new Produto(10, "Webcam HD", "Periféricos", 250.0, 7, true, "Logitech"),
            new Produto(11, "Suporte Notebook", "Acessórios", 120.0, 15, true, "Multilaser"),
            new Produto(12, "Hub USB", "Acessórios", 90.0, 20, true, "Baseus"),
            new Produto(13, "Mouse Gamer", "Periféricos", 150.0, 12, true, "Redragon"),
            new Produto(14, "Luminária LED", "Acessórios", 180.0, 0, true, "Xiaomi"),
            new Produto(15, "SSD 1TB", "Informática", 480.0, 9, true, "Kingston"),
            new Produto(16, "Memória RAM 16GB", "Informática", 410.0, 11, true, "Corsair")
    );

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.println("\n\n<< Menu >>");
            System.out.println(" [1] - Mostrar produtos cadastrados");
            System.out.println(" [2] - Mostrar produtos ativos e com estoque maior que zero ordenados por categoria e depois por nome");
            System.out.println(" [3] - Mostrar nome - categoria - preco de produtos ativos ordenando do maior preco para o menor");
            System.out.println(" [4] - Mostrar apenas os nomes dos produtos inativos ou sem estoque, em ordem alfabética");
            System.out.println(" [5] - Mostrar nome dos produtos da categoria Periféricos em maiúsculo, sem repetir nomes, ordenados alfabeticamente");
            System.out.println(" [6] - Mostrar MARCA :: NOME, somente para produtos ativoss com estoque maior que zero, ordenados por marca e depois por nome");
            System.out.println(" [7] - Montar um Map com id e nome do produto");
            System.out.println(" [8] - Agrupar Nome dos produtos por categoria");
            System.out.println(" [9] - Agrupar produtos por categoria");
            System.out.println(" [10] - Agrupar produtos por marca");
            System.out.println(" [11] - Agrupar apenas produtos ativos por categoria");
            System.out.println(" [12] - Agrupar apenas produtos com estoque maior que zero por marca");
            System.out.println(" [0] - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = Integer.parseInt(scanner.nextLine());

            //Exercicios
            //Bloco A
                //Retorne uma lista com os produtos ativos e com estoque maior que zero, ordenados por categoria e depois por nome. - done
                //Retorne uma lista de strings no formato: "nome - categoria - preço", apenas para produtos ativos, ordenando do maior preço para o menor. - done
                //Retorne apenas os nomes dos produtos inativos ou sem estoque, em ordem alfabética. - done
                //Retorne os nomes dos produtos da categoria "Periféricos" em maiúsculo, sem repetir nomes, ordenados alfabeticamente. - done
                //Retorne uma lista no formato: "MARCA :: NOME", somente dos produtos ativos com estoque maior que zero, ordenados por marca e depois por nome.
            //Bloco B
                //Busque o primeiro produto ativo da categoria "Informática" ordenado por menor preço.
                //Busque o nome do primeiro produto da marca "Redragon" em ordem alfabética.
                //Busque o primeiro produto cujo nome contém "Notebook" e devolva um Optional<String> com o nome dele em maiúsculo.
            //Bloco C
                //Calcule o valor total em estoque apenas dos produtos ativos.
                //Calcule o menor preço entre os produtos ativos com estoque maior que zero.
                //Calcule a soma dos preços de todos os produtos da marca "Logitech".
            //Bloco D
                //Use reduce para somar todos os preços dos produtos ativos.
                //Use reduce para concatenar todos os nomes dos produtos em uma única string, separados por " | ".
                //Use reduce para calcular o valor total em estoque da loja, em vez de usar mapToDouble(...).sum().
            //Bloco E
                //Agrupar produtos por categoria
                //Agrupar produtos por marca
                //Agrupar nomes por categoria
                //Agrupar apenas produtos ativos por categoria - primeiro filtre os ativos, depois agrupe por categoria
                //Agrupar apenas produtos com estoque maior que zero por marca
            //Bloco F
                //Calcular quantidade de produtos por categoria
                //Quantidade de produtos ativos por categoria
                //Calcular a quantidade de estoque por categoria
                //Calcular a soma dos preços por categoria
                //Calcular valor total em estoque por categoria
                //Calcular a média de preço por categoria
                //Calcular a média de preço apenas dos produtos ativos por marca

           switch (opcao) {
               case 0 -> System.out.println("Saindo...");
               case 1 -> TabelaFormatada.tabelaFormatadaForList(produtos);
               case 2 -> mostrarProdutosAtivosAndEstoqueMaiorQueZeroOrdenadosPorCategoriaDepoisPorNome();
               case 3 -> mostrarNomeCategoriaPrecoProdutosAtivosOrdenadosPorPrecoReverso();
               case 4 -> mostrarNomeDosProdutosInativosOuSemEstoqueOrdemAlfabetica();
               case 5 -> mostrarNomeProdutosCategoriaPerifericosMaiusculoSemRepetirOrdemAlfabetica();
               case 6 -> mostrarMarcaAndNomeProdutosAtivosAndEstoqueMaiorQueZeroOrdenadosPorMarcaDepoisPorNome();
               case 7 -> montarMapNomeIdProduto();
               case 8 -> agruparNomeProdutosPorCategoria();
               case 9 -> agruparProdutosPorCategoria();
               case 10 -> agruparProdutosPorMarca();
               default -> System.out.println("Opcao invalida");
           }
        } while (opcao != 0);

    }

    public static void mostrarProdutosAtivosAndEstoqueMaiorQueZeroOrdenadosPorCategoriaDepoisPorNome() {
        List<Produto> produtos1 = produtos.stream()
                .filter(produto -> produto.getAtivo() && produto.getEstoque() > 0)
                .sorted(Comparator.comparing(Produto::getCategoria)
                        .thenComparing(Produto::getNome))
                .toList();

        System.out.println();
        System.out.println("<< Produtos ativos e com estoque maior que zero ordenado por categoria e depois por nome >>");
        TabelaFormatada.tabelaFormatadaForList(produtos1);
    }

    public static void mostrarNomeCategoriaPrecoProdutosAtivosOrdenadosPorPrecoReverso() {
        List<String> camposProdutos = produtos.stream()
                .filter(Produto::getAtivo)
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .map(produto -> produto.getNome() + " - " + produto.getCategoria() + " - " + produto.getPreco())
                .toList();


        System.out.println();
        System.out.println("<< Mostrando nome categoria e preco de produtos ativos ordenados por preco >>");
        camposProdutos.stream()
                .forEach(System.out::println);
    }

    public static void mostrarNomeDosProdutosInativosOuSemEstoqueOrdemAlfabetica() {
        List<String> nomeProdutosInativosOuSemEstoqueOrdemAlfabetica = produtos.stream()
                .filter(produto -> !produto.getAtivo() || produto.getEstoque() == 0)
                .map(Produto::getNome)
                .sorted()
                .toList();

        System.out.println();
        System.out.println("<< Mostrando nome dos produtos inativos ou sem estoque em ordem alfabetic >>");
        nomeProdutosInativosOuSemEstoqueOrdemAlfabetica.stream()
                .forEach(System.out::println);
    }

    public static void mostrarNomeProdutosCategoriaPerifericosMaiusculoSemRepetirOrdemAlfabetica() {
        List<String> nomeProdutos = produtos.stream()
                .filter(produto -> produto.getCategoria().equals("Periféricos"))
                .map(produto -> produto.getNome().toUpperCase())
                .distinct()
                .sorted()
                .toList();

        System.out.println();
        System.out.println("<< Nome dos produtos da categoria Periféricos em maiúsculo, sem repetir nomes, ordenados alfabeticamente >>");
        nomeProdutos.stream()
                .forEach(System.out::println);
    }

    //Retorne uma lista no formato: "MARCA :: NOME", somente dos produtos ativos com estoque maior que zero, ordenados por marca e depois por nome.
    public static void mostrarMarcaAndNomeProdutosAtivosAndEstoqueMaiorQueZeroOrdenadosPorMarcaDepoisPorNome() {
        List<String> marcaAndNomeProdutos = produtos.stream()
                .filter(produto -> produto.getAtivo() && produto.getEstoque() > 0)
                .sorted(Comparator.comparing(Produto::getMarca)
                        .thenComparing(Produto::getNome))
                .map(produto -> produto.getMarca().toUpperCase() + " :: " + produto.getNome().toUpperCase())
                .toList();

        System.out.println();
        System.out.println("<< Mostrando MARCA :: NOME, somente para produtos atvios com estoque maior que zero, ordenados por marca e depor por nome");
        marcaAndNomeProdutos.stream()
                .forEach(System.out::println);
    }

    public static void montarMapNomeIdProduto() {
        Map<Integer,String> nomeProduto = produtos.stream()
                .collect(Collectors.toMap(
                        Produto::getId,
                        Produto::getNome
                ));

        System.out.println();
        System.out.println("<< Mostrando id e nome do produto em um map >>");
        nomeProduto.entrySet().stream()
                .forEach(entry -> System.out.println("Id: " + entry.getKey() + " | Value: " + entry.getValue()));
    }

    public static void agruparNomeProdutosPorCategoria() {
        Map<String,List<String>> nomeProdutosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(
                        Produto::getCategoria,
                        Collectors.mapping(Produto::getNome, Collectors.toList())
                        ));

        System.out.println();
        System.out.println("<< Nomes dos produtos agrupados por categoria >>");
        nomeProdutosPorCategoria.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()
                        .stream()
                        .reduce("", (a,b) -> a + " | " + b)));
    }

    public static void agruparProdutosPorCategoria() {
        Map<String,List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        System.out.println();
        System.out.println("<< Produtos agrupados por categoria >>");
        produtosPorCategoria.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()
                        .stream()
                        .map(Produto::toString)
                        .reduce("", (a, b) -> a + " | " + b)));

    }

    public static void agruparProdutosPorMarca() {
        Map<String,List<Produto>> produtosPorMarca = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getMarca));

        System.out.println();
        System.out.println("<< Produtos agrupados por marca >>");
        produtosPorMarca.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()
                        .stream()
                        .map(Produto::toString)
                        .reduce("", (a, b) -> a + " | " + b)));

    }


}
