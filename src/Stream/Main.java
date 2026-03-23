package Stream;

import java.util.*;

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
            System.out.println(" [0] - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = Integer.parseInt(scanner.nextLine());

            //Exercicios
            //Bloco A
                //Retorne uma lista com os produtos ativos e com estoque maior que zero, ordenados por categoria e depois por nome.
                //Retorne uma lista de strings no formato: "nome - categoria - preço", apenas para produtos ativos, ordenando do maior preço para o menor.
                //Retorne apenas os nomes dos produtos inativos ou sem estoque, em ordem alfabética.
                //Retorne os nomes dos produtos da categoria "Periféricos" em maiúsculo, sem repetir nomes, ordenados alfabeticamente.
                //Retorne os produtos da marca "Logitech" que estejam ativos, ordenados pelo preço crescente.
                //Retorne os nomes dos produtos com preço entre 100 e 500, ordenados primeiro pela categoria e depois pelo nome.
                //Retorne uma lista no formato: "MARCA :: NOME", somente dos produtos ativos com estoque maior que zero, ordenados por marca e depois por nome.
            //Bloco B
                //Busque o primeiro produto ativo da categoria "Informática" ordenado por menor preço.
                //Busque qualquer produto com estoque zero.
                //Busque o nome do primeiro produto da marca "Redragon" em ordem alfabética.
                //Busque o produto ativo mais barato da categoria "Periféricos"
                //Busque o primeiro produto cujo nome contém "Notebook" e devolva um Optional<String> com o nome dele em maiúsculo.
            //Bloco C
                //Calcule quantos produtos ativos existem.
                //Calcule o estoque total da loja.
                //Calcule o valor total em estoque da loja.
                //Calcule o valor total em estoque apenas dos produtos ativos.
                //Calcule a média de preço dos produtos ativos.
                //Calcule o maior preço entre os produtos da categoria "Informática".
                //Calcule o menor preço entre os produtos ativos com estoque maior que zero.
                //Calcule a soma dos preços de todos os produtos da marca "Logitech".
                //Calcule a quantidade de unidades em estoque apenas dos produtos da categoria "Acessórios".
            //Bloco D
                //Use reduce para somar todos os preços dos produtos ativos.
                //Use reduce para somar o estoque total.
                //Use reduce para concatenar todos os nomes dos produtos em uma única string, separados por " | ".
                //Use reduce para gerar um texto com os nomes apenas dos produtos ativos.
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
               default -> System.out.println("Opcao invalida");
           }
        } while (opcao != 0);

    }

}
