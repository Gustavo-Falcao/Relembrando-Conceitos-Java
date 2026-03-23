package Stream;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import Agenda_Contatos.TabelaFormatada;
import Estoque_Produtos.Service.ProdutoService;

import javax.swing.plaf.ProgressBarUI;

public class Main {

    private static List<Produto> produtos = List.of(
            new Produto(6,"Mouse Gamer", "Periféricos", 150.0, 10, true),
            new Produto(7,"Teclado Mecânico", "Periféricos", 320.0, 5, true),
            new Produto(3,"Monitor 24", "Monitores", 900.0, 3, false),
            new Produto(8,"Monitor 27", "Monitores", 1200.0, 0, true),
            new Produto(11,"Notebook i5", "Informática", 3500.0, 2, true),
            new Produto(1,"Notebook i7", "Informática", 5000.0, 1, false),
            new Produto(2,"Cadeira Gamer", "Móveis", 850.0, 4, true),
            new Produto(4,"Mesa Escrivaninha", "Móveis", 650.0, 6, true),
            new Produto(9,"Headset Pro", "Periféricos", 280.0, 8, false),
            new Produto(10,"Webcam HD", "Periféricos", 250.0, 7, true),
            new Produto(15,"Suporte Notebook", "Acessórios", 120.0, 15, true),
            new Produto(13,"Hub USB", "Acessórios", 90.0, 20, true),
            new Produto(14,"Mouse Gamer", "Periféricos", 150.0, 12, false),
            new Produto(12,"Luminária LED", "Acessórios", 180.0, 0, true)
    );


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.println("\n\n<< Menu >>");
            System.out.println(" [1] - Listar todos os produtos");
            System.out.println(" [2] - Listar todos os produtos ativos");
            System.out.println(" [3] - Listar todos os produtos inativos");
            System.out.println(" [4] - Listar todos os produtos com estoque maior que 0");
            System.out.println(" [5] - Listar todos os produtos com preco maior que 500");
            System.out.println(" [6] - Listar apenas os produtos com a categoria Periféricos");
            System.out.println(" [7] - Listar apenas o nome dos produtos");
            System.out.println(" [8] - Listar apenas o preco dos produtos");
            System.out.println(" [9] - Listar apenas o nome dos produtos em maiusculo");
            System.out.println(" [10] - Listar apenas nome dos produtos sem repetir");
            System.out.println(" [11] - Ordenar produtos pelo preco crescente");
            System.out.println(" [12] - Ordenar produtos pelo preco decrescente");
            System.out.println(" [13] - Ordenar produtos pelo nome em ordem alfabetica");
            System.out.println(" [14] - Ordenar produtos pelo tamanho do nome crescente");
            System.out.println(" [15] - Ordenar produtos pelo id crescente");
            System.out.println(" [16] - Ordenar produtos pelo estoque decrescente");
            System.out.println(" [17] - Ordenar produtos pelo estoque crescente");
            System.out.println(" [18] - Ordenar produtos pela categoria em ordem alfabetica");
            System.out.println(" [19] - Ordenar produtos pela categoria em ordem alfabetica reversa");
            System.out.println(" [20] - Ordenar produtos pela categoria em ordem alfabetica se categoria for igual, ordenar pelo nome");
            System.out.println(" [21] - Ordenar produtos pela categoria em ordem alfabetica reversa se categoria for igual, ordenar pelo nome em ordem normal");
            System.out.println(" [22] - Listar produtos que estão ativos e tem estoque maior que 0");
            System.out.println(" [23] - Listar produtos da categoria Periféricos que custam mais de 200");
            System.out.println(" [24] - Listar produtos que estão inativos ou com estoque igual a 0");
            System.out.println(" [25] - Listar produtos que tem Monitor no nome");
            System.out.println(" [26] - Listar produtos cujo nome começa com M e que estão ativos");
            System.out.println(" [27] - Listar produtos que estão ativos e o preço está entre 200 e 1000");
            System.out.println(" [28] - Listar produtos que tem estoque menor que 5 e estão ativos");
            System.out.println(" [29] - Listar produtos que não são da categoria Acessórios");
            System.out.println(" [30] - Listar tamanho dos nomes dos produtos");
            System.out.println(" [31] - Listar nome e categoria do produto");
            System.out.println(" [32] - Listar nome e preço do produto");
            System.out.println(" [33] - Listar nome dos produtos ativos");
            System.out.println(" [34] - Listar nome dos produtos da categoria Monitores");
            System.out.println(" [35] - Listar nome dos produtos ativos e com estoque maior que zero em maiúsculo");
            System.out.println(" [36] - Listar categorias dos produtos que tem preço menor que 200");
            System.out.println(" [37] - Listar nome e categoria do produto em maiusculo para produtos ativos");
            System.out.println(" [0] - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = Integer.parseInt(scanner.nextLine());

            //Exercicios
            // Retorne uma lista com os produtos que estão ativos e têm estoque maior que zero. - done
            //Retorne uma lista com os produtos da categoria "Periféricos" que custam mais de 200. - done
            // Retorne uma lista com os produtos inativos ou com estoque igual a zero. - done
            //Retorne uma lista com os produtos cujo nome contém a palavra "Monitor". - done
            //Retorne uma lista com os produtos cujo nome começa com "M" e que estão ativos. - done
            //Retorne uma lista com os produtos que não pertencem à categoria "Acessórios". - done
            //Retorne uma lista com os produtos ativos cujo preço está entre 200 e 1000. - done
            //Retorne uma lista com os produtos que têm estoque menor que 5 e estão ativos. - done
            //Crie uma List<Integer> com o tamanho de cada nome de produto. - done
            //Crie uma List<String> no formato: "Mouse Gamer - Periféricos" - para cada produtos - done
            //Crie uma List<String> no formato: "Produto: Mouse Gamer | Preço: 150.0" - para cada produto - done
            //Crie uma List<String> com os nomes dos produtos ativos. - done
            //Retorne uma List<String> com os nomes dos produtos da categoria "Monitores". - done
            //Retorne uma List<String> com os nomes dos produtos ativos e com estoque maior que zero, em maiúsculo. - done
            //Retorne uma List<String> com as categorias dos produtos que têm preço menor que 200. - done
            //Retorne uma List<String> no formato: "NOTEBOOK I5 - INFORMÁTICA" - para produtos ativos - done
            //Ordene os produtos pelo nome em ordem alfabética. - done
            //Ordene os produtos pelo preço em ordem crescente. - done
            //Ordene os produtos pelo preço em ordem decrescente. - done
            //Ordene os produtos pelo estoque em ordem crescente. - done
            //Ordene os produtos pela categoria em ordem alfabética. - done
            //Ordene os produtos pela categoria em ordem alfabética reversa. - done
            //Ordene os produtos primeiro pela categoria e, se a categoria for igual, pelo nome. - done
            //Ordene os produtos primeiro pela categoria em ordem reversa e, se a categoria for igual, pelo nome em ordem normal. - done



           switch (opcao) {
               case 1 -> TabelaFormatada.tabelaFormatadaForList(produtos);
               case 2 -> ListarProdutosAtivos();
               case 3 -> ListarProdutosInativos();
               case 4 -> ListarProdutosEstoqueMaiorQue0();
               case 5 -> ListarProdutosComPrecoMaiorQue500();
               case 6 -> ListarProdutosComCategoriaPerifericos();
               case 7 -> ListarApenasNomeDosProdutos();
               case 8 -> ListarApenasPrecoDosProdutos();
               case 9 -> ListarApenasNomeDosProdutosEmMaiusculo();
               case 10 -> ListarNomeProdutosSemRepetir();
               case 11 -> OrdenarProdutosPorPrecoCrescente();
               case 12 -> OrdenarProdutosPorPrecoDecrescente();
               case 13 -> OrdenarProdutosPorNomeOrdemAlfabetica();
               case 14 -> OrdenarProdutosPorLengthNomeCrescente();
               case 15 -> OrdenarProdutosPorIdCrescente();
               case 16 -> OrdenarProdutosPorEstoqueDecrescente();
               case 17 -> OrdenarProdutosPorEstoqueCrescente();
               case 18 -> OrdenarProdutosPorCategoriaOrdemAlfabetica();
               case 19 -> OrdenarProdutosPorCategoriaOrdemAlfabeticaReversa();
               case 20 -> OrdenarProdutosPorCategoriaOrdemAlfabeticaSeCategoriaForIgualOrdenarPorNome();
               case 21 -> OrdenarProdutosPorCategoriaOrdemAlfabeticaReversaSeCategoriaForIgualOrdenarPeloNomeOrdemNormal();
               case 22 -> ListarProdutosAtivosComEstoqueIgualZero();
               case 23 -> ListarProdutosDePerifericosComPrecoMaiorQueDuzentos();
               case 24 -> ListarProdutosInativosOuComEstoqueIgualZero();
               case 25 -> ListarProdutosQueTenhaMonitorNoNome();
               case 26 -> ListarProdutosQueNomeComecaComMeEstaAtivo();
               case 27 -> ListarProdutosAtivosComPrecoEntre200And1000();
               case 28 -> ListarProdutosComEstoqueMenorQue5Ativos();
               case 29 -> ListarProdutosQueNaoSaoAcessorios();
               case 30 -> ListarTamanhoDosNomesDosProdutos();
               case 31 -> ListarNomeAndCategoriaProduto();
               case 32 -> ListarNomeAndPrecoProduto();
               case 33 -> ListarNomeDosProdutosAtivos();
               case 34 -> ListarNomeProdutosCategoriaMonitores();
               case 35 -> ListarNomeProdutosAtivosAndEstoqueMaiorQueZeroEmMaiusculo();
               case 36 -> ListarCategoriasDeProdutosQueTemPrecoMenorQueDuzentos();
               case 37 -> ListarNomeAndCategoriaProdutosAtivosMaiusculo();
               case 0 -> System.out.println("Saindo...");
               default -> System.out.println("Opcao invalida");
           }
        } while (opcao != 0);

    }

    public static void ListarProdutosAtivos() {
        List<Produto>produtosAtivos = produtos.stream()
                .filter(p -> p.getAtivo() == true)
                .toList();

        System.out.println();
        System.out.println("Produtos Ativos");
        TabelaFormatada.tabelaFormatadaForList(produtosAtivos);
    }

    public static void ListarProdutosInativos() {
        List<Produto> produtosInativos = produtos.stream()
                .filter(p -> p.getAtivo() != true)
                .toList();

        System.out.println();
        System.out.println("Produtos Inativos");
        TabelaFormatada.tabelaFormatadaForList(produtosInativos);
    }

    public static void ListarProdutosEstoqueMaiorQue0() {
        List<Produto> produtosEstoqueMaiorQue0 = produtos.stream()
                .filter(produto -> produto.getEstoque() > 0)
                .toList();

        System.out.println();
        System.out.println("Produtos com estoque maior que 0");

        TabelaFormatada.tabelaFormatadaForList(produtosEstoqueMaiorQue0);
    }

    public static void ListarProdutosComPrecoMaiorQue500() {
        List<Produto> produtoComPrecoMaiorQue500 = produtos.stream()
                .filter(produto -> produto.getPreco() > 500)
                .toList();

        System.out.println();
        System.out.println("Produtos com preco maior que 500");

        TabelaFormatada.tabelaFormatadaForList(produtoComPrecoMaiorQue500);
    }

    public static void ListarProdutosComCategoriaPerifericos() {
        List<Produto> produtosComCategoriaPeriferico = produtos.stream()
                .filter(produto -> produto.getCategoria().equals("Periféricos"))
                .toList();

        System.out.println();
        System.out.println("Produtos com categoria Periféricos");

        TabelaFormatada.tabelaFormatadaForList(produtosComCategoriaPeriferico);
    }

    public static void ListarApenasNomeDosProdutos() {
        List<String> nomeProdutos = produtos.stream()
                .map(Produto::getNome)
                .toList();

        System.out.println();
        System.out.println("<< Nome produtos >>");
        nomeProdutos.stream()
                .forEach(System.out::println);
    }

    public static void ListarApenasPrecoDosProdutos() {
        List<Double> precoProdutos = produtos.stream()
                .map(Produto::getPreco)
                .toList();

        System.out.println();
        System.out.println("<< Preco dos produtos >>");
        precoProdutos.stream()
                .forEach(System.out::println);
    }

    public static void ListarApenasNomeDosProdutosEmMaiusculo() {
        List<String> nomeProdutosMaiusculo = produtos.stream()
                .map(Produto::getNome)
                .map(String::toUpperCase)
                .toList();

        System.out.println();
        System.out.println("<< Nome produtos em maiusculo >>");
        nomeProdutosMaiusculo.stream()
                .forEach(System.out::println);
    }

    public static void ListarNomeProdutosSemRepetir() {
        List<String> produtosSemNomeRepetido = produtos.stream()
                .map(Produto::getNome)
                .distinct()
                .toList();

        System.out.println();
        System.out.println("<< Nome produtos sem repetir >>");
        produtosSemNomeRepetido.stream()
                .forEach(System.out::println);
    }

    public static void OrdenarProdutosPorPrecoCrescente() {
        List<Produto> produtosOrdenadosPorPrecoCrescente = produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco))
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados por preco ordem crescente >>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosPorPrecoCrescente);
    }

    public static void OrdenarProdutosPorPrecoDecrescente() {
        List<Produto> produtosOrdenadosPorPrecoDecrescente = produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados por preco ordem decrescente >>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosPorPrecoDecrescente);
    }

    public static void OrdenarProdutosPorNomeOrdemAlfabetica() {
        List<Produto> produtosOrdenadosOrdemAlfabetica = produtos.stream()
                .sorted(Comparator.comparing(Produto::getNome).reversed())
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados por ordem alfabetica >>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosOrdemAlfabetica);
    }

    public static void OrdenarProdutosPorLengthNomeCrescente() {
        List<Produto> produtosOrdenadosPorLengthNome = produtos.stream()
                .sorted(Comparator.comparing(produto -> produto.getNome().length()))
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados pelo tamanho do nome crescente >>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosPorLengthNome);
    }

    public static void OrdenarProdutosPorIdCrescente() {
        List<Produto> produtosOrdenadosPorIdCrescente = produtos.stream()
                .sorted(Comparator.comparing(Produto::getId))
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados por Id ordem crescente >>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosPorIdCrescente);
    }

    public static void OrdenarProdutosPorEstoqueDecrescente() {
        List<Produto> produtosOrdenadosPorEstoqueDecrescente = produtos.stream()
                .sorted(Comparator.comparing(Produto::getEstoque)
                        .thenComparing(Produto::getNome)
                        .reversed())
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados por estoque ordem decrescente >>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosPorEstoqueDecrescente);
    }

    public static void OrdenarProdutosPorEstoqueCrescente() {
        List<Produto> produtosOrdenadosPorEstoqueCrescente = produtos.stream()
                .sorted(Comparator.comparing(Produto::getEstoque))
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados por estoque ordem crescente >>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosPorEstoqueCrescente);
    }

    public static void OrdenarProdutosPorCategoriaOrdemAlfabetica() {
        List<Produto> produtosOrdenadosPorCategoriaOrdemAlfabetica = produtos.stream()
                .sorted(Comparator.comparing(Produto::getCategoria))
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados por categoria em ordem alfabetica >>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosPorCategoriaOrdemAlfabetica);
    }

    public static void OrdenarProdutosPorCategoriaOrdemAlfabeticaReversa() {
        List<Produto> produtosOrdenadosPorCategoriaOrdemAlfabeticaReversa = produtos.stream()
                .sorted(Comparator.comparing(Produto::getCategoria).reversed())
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados por categoria em ordem alfabetica reversa>>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosPorCategoriaOrdemAlfabeticaReversa);
    }

    public static void OrdenarProdutosPorCategoriaOrdemAlfabeticaSeCategoriaForIgualOrdenarPorNome() {
        List<Produto> produtosOrdenadosPorCategoriaElsePorNome = produtos.stream()
                .sorted(Comparator.comparing(Produto::getCategoria)
                        .thenComparing(Produto::getNome))
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados por categoria e se categoria for igual então ordenado pelo nome >>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosPorCategoriaElsePorNome);
    }

    public static void OrdenarProdutosPorCategoriaOrdemAlfabeticaReversaSeCategoriaForIgualOrdenarPeloNomeOrdemNormal() {
        List<Produto> produtosOrdenadosPorCategoriaOrdemReversaElsePorNomeOrdemNormal = produtos.stream()
                .sorted(Comparator.comparing(Produto::getCategoria, Comparator.reverseOrder())
                        .thenComparing(Produto::getNome))
                .toList();

        System.out.println();
        System.out.println("<< Produtos ordenados por categoria em ordem alfabetica reversa e se categoria for igual então ordenado por nome em ordem alfabetica normal >>");
        TabelaFormatada.tabelaFormatadaForList(produtosOrdenadosPorCategoriaOrdemReversaElsePorNomeOrdemNormal);
    }

    public static void ListarProdutosAtivosComEstoqueIgualZero() {
        List<Produto> produtosAtivosComEstoqueMaiorQueZero = produtos.stream()
                .filter(produto -> produto.getAtivo() == true && produto.getEstoque() == 0)
                .toList();

        System.out.println();
        System.out.println("<< Produtos ativos com estoque menor que zero >>");
        TabelaFormatada.tabelaFormatadaForList(produtosAtivosComEstoqueMaiorQueZero);
    }

    public static void ListarProdutosDePerifericosComPrecoMaiorQueDuzentos() {
        List<Produto> produtosPerifericosComPrecoMaiorQueDuzentos = produtos.stream()
                .filter(produto -> produto.getCategoria().equals("Periféricos") && produto.getPreco() > 200)
                .toList();

        System.out.println();
        System.out.println("<< Produtos periféricos com preco maior que duzentos >>");
        TabelaFormatada.tabelaFormatadaForList(produtosPerifericosComPrecoMaiorQueDuzentos);
    }
  
    public static void ListarProdutosInativosOuComEstoqueIgualZero() {
        List<Produto> produtosInativosOuComEstoqueIgualZero = produtos.stream()
                .filter(produto -> !produto.getAtivo() || produto.getEstoque() == 0)
                .toList();

        System.out.println();
        System.out.println("<< Produtos Inativos ou com estoque igual a zero >>");
        TabelaFormatada.tabelaFormatadaForList(produtosInativosOuComEstoqueIgualZero);
    }

    public static void ListarProdutosQueTenhaMonitorNoNome() {
        List<Produto> produtosQueTemMonitorNoNome = produtos.stream()
                .filter(produto -> produto.getNome().contains("Monitor"))
                .toList();

        System.out.println();
        System.out.println("<< Produtos que tem Monitor no nome >>");
        TabelaFormatada.tabelaFormatadaForList(produtosQueTemMonitorNoNome);
    }

    public static void ListarProdutosQueNomeComecaComMeEstaAtivo() {
        List<Produto> produtosQueComecamComMeAtivo = produtos.stream()
                .filter(produto -> produto.getNome().charAt(0) == 'M' && produto.getAtivo())
                .toList();

        System.out.println();
        System.out.println("<< Produtos cujo nome começa com a letra M e está ativo >>");
        TabelaFormatada.tabelaFormatadaForList(produtosQueComecamComMeAtivo);
    }
  
    public static void ListarProdutosQueNaoSaoAcessorios() {
        List<Produto> produtosQueNaoSaoAcessorios = produtos.stream()
                .filter(produto -> !produto.getCategoria().equals("Acessórios"))
                .toList();

        System.out.println();
        System.out.println("<< Produtos que não são acessorios >>");
        TabelaFormatada.tabelaFormatadaForList(produtosQueNaoSaoAcessorios);
    }

    public static void ListarProdutosAtivosComPrecoEntre200And1000() {
        List<Produto> produtosAtivosComPrecoEntre200And1000 = produtos.stream()
                .filter(produto -> produto.getAtivo() && produto.getPreco() >= 200 && produto.getPreco() <= 1000)
                .toList();

        System.out.println();
        System.out.println("<< Produtos ativos com preco entre 200 e 1000 >>");
        TabelaFormatada.tabelaFormatadaForList(produtosAtivosComPrecoEntre200And1000);
    }

    public static void ListarProdutosComEstoqueMenorQue5Ativos() {
        List<Produto> produtosComEstoqueMenorQue5Ativos = produtos.stream()
                .filter(produto -> produto.getEstoque() < 5 && produto.getAtivo())
                .toList();

        System.out.println();
        System.out.println("<< Produtos com estoque menor que 5 e que estão ativo >>");
        TabelaFormatada.tabelaFormatadaForList(produtosComEstoqueMenorQue5Ativos);
    }

    public static void ListarTamanhoDosNomesDosProdutos() {
        List<Integer> tamanhoNomeDosProdutos = produtos.stream()
                .map(produto -> produto.getNome().length())
                .toList();

        System.out.println();
        System.out.println("<< Tamanho dos nomes dos produtos >>");
        tamanhoNomeDosProdutos.stream()
                .forEach(System.out::println);
    }

    public static void ListarNomeAndCategoriaProduto() {
        //Mouse Gamer - Periféricos
        List<String> nomeAndCategoriaProduto = produtos.stream()
                .map(produto -> produto.getNome() + " - " + produto.getCategoria())
                .toList();

        System.out.println();
        System.out.println("<< Nome e categoria de cada produto >>");
        nomeAndCategoriaProduto.stream()
                .forEach(System.out::println);
    }

    public static void ListarNomeAndPrecoProduto() {
        List<String> nomeAndPrecoProduto = produtos.stream()
                .map(produto -> produto.getNome() + " | " + produto.getPreco())
                .toList();

        System.out.println();
        System.out.println("<< Nome e preco de cada produto >>");
        nomeAndPrecoProduto.stream()
                .forEach(System.out::println);
    }

    public static void ListarNomeDosProdutosAtivos() {
        List<String> nomeProdutosAtivos = produtos.stream()
                .filter(produto -> produto.getAtivo())
                .map(Produto::getNome)
                .toList();

        System.out.println();
        System.out.println("<< Nome dos produtos ativos >>");
        nomeProdutosAtivos.stream()
                .forEach(System.out::println);
    }

    public static void ListarNomeProdutosCategoriaMonitores() {
        List<String> nomeProdutosCategoriaMonitores = produtos.stream()
                .filter(produto -> produto.getCategoria().equals("Monitores"))
                .map(Produto::getNome)
                .toList();

        System.out.println();
        System.out.println("<< Nome produtos da categoria Monitores >>");
        nomeProdutosCategoriaMonitores.stream()
                .forEach(System.out::println);
    }

    public static void ListarNomeProdutosAtivosAndEstoqueMaiorQueZeroEmMaiusculo() {
        List<String> nomeProdutosAtivosAndEstoqueMaiorQueZeroMaiusculo = produtos.stream()
                .filter(produto -> produto.getAtivo() && produto.getEstoque() > 0)
                .map(produto -> produto.getNome().toUpperCase())
                .toList();

        System.out.println();
        System.out.println("<< Nome produtos ativos e com estoque maior que zero maiusculo >>");
        nomeProdutosAtivosAndEstoqueMaiorQueZeroMaiusculo.stream()
                .forEach(System.out::println);
    }

    public static void ListarCategoriasDeProdutosQueTemPrecoMenorQueDuzentos() {
        List<String> categoriasDeProdutosComPrecoMenorQueDuzentos = produtos.stream()
                .filter(produto -> produto.getPreco() < 200)
                .map(Produto::getCategoria)
                .distinct()
                .toList();

        System.out.println();
        System.out.println("<< Nome das categorias de produtos que tem preco menor que duzentos >>");
        categoriasDeProdutosComPrecoMenorQueDuzentos.stream()
                .forEach(System.out::println);
    }

    public static void ListarNomeAndCategoriaProdutosAtivosMaiusculo() {
        List<String> nomeAndCategoriaProdutoMaiusculo = produtos.stream()
                .filter(produto -> produto.getAtivo())
                .map(produto -> produto.getNome().toUpperCase() + " - " + produto.getCategoria().toUpperCase())
                .toList();

        System.out.println();
        System.out.println("<< Nome e categoria do produto em maiusculo >>");
        nomeAndCategoriaProdutoMaiusculo.stream()
                .forEach(System.out::println);
    }

}
