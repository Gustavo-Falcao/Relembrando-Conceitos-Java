package Estoque_Produtos.Dados;

import Estoque_Produtos.Helpers.CurrencyFormatter;
import Estoque_Produtos.Produto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ExportDados {
    private static String filePath = "src/Estoque_Produtos/Dados/produtos.csv";
    public static void exportDataToCsvFile(Map<String, Produto> produtos) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);

            fileWriter.write("SKU;Nome;Preco;QuantEstoque\n");

            for(Produto produto : produtos.values()) {
                fileWriter.write(produto.getSku() + ";" + produto.getNome() + ";" + CurrencyFormatter.currencyFormatter(produto.getPreco(), 2) + ";" + produto.getQuantidade() + "\n");
            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
