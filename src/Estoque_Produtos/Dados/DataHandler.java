package Estoque_Produtos.Dados;

import Estoque_Produtos.Helpers.CurrencyFormatter;
import Estoque_Produtos.Produto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataHandler {

    private static String filePath = "src/Estoque_Produtos/Dados/produtos.csv";

    public static void exportDataToCsvFile(Map<String, Produto> produtos) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, StandardCharsets.UTF_8);

            fileWriter.write("SKU;Nome;Preco;QuantEstoque\n");

            for(Produto produto : produtos.values()) {
                fileWriter.write(produto.getSku() + ";" + produto.getNome() + ";" + CurrencyFormatter.currencyFormatter(produto.getPreco()) + ";" + produto.getQuantidade() + "\n");
            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String,Produto> loadDataFromCsv() {
        String linha;
        Map<String, Produto> produtoMap = new HashMap<>();
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                linha = scanner.nextLine();
                String [] atributos = linha.split(";");

                String sku = atributos[0];
                String nome = atributos[1];
                double preco = Double.parseDouble(atributos[2].replace("R$", ""));
                int quantidade = Integer.parseInt(atributos[3]);

                produtoMap.put(sku, new Produto(sku, nome, preco, quantidade));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return produtoMap;
    }
}
