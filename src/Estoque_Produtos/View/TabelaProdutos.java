package Estoque_Produtos.View;

import Estoque_Produtos.Produto;
import com.sun.tools.jconsole.JConsoleContext;

import java.util.Map;

public class TabelaProdutos {

    public static void tabelaProdutos(Map<String, Produto> produtos) {

        int maiorLengthCodigoProduto = 0;
        int maiorLengthNome = 0;
        int maiorLengthPreco = 0;
        int maiorLengthQuantidade = 0;

        for(Map.Entry<String, Produto> entry : produtos.entrySet()) {
            maiorLengthCodigoProduto = Math.max(maiorLengthCodigoProduto, entry.getKey().length());
            maiorLengthNome = Math.max(maiorLengthNome, entry.getValue().getNome().length());
            maiorLengthPreco = Math.max(maiorLengthPreco, String.valueOf(entry.getValue().getPreco()).length());
            maiorLengthQuantidade = Math.max(maiorLengthQuantidade, String.valueOf(entry.getValue().getPreco()).length());
        }

        int widthCodigoProduto = maiorLengthCodigoProduto + 6;
        int widthNome = maiorLengthNome + 6;
        int widthPreco = maiorLengthPreco + 6;
        int widthQuantidade = maiorLengthQuantidade + 10;

        String tituloCodigoProduto = "SKU";
        String tituloNome = "Nome";
        String tituloPreco = "Preco";
        String tituloQuantidade = "Quantidade";

        String linhaTituloProdutos = "|" + campoFormatado(widthCodigoProduto, tituloCodigoProduto) + "|" + campoFormatado(widthNome, tituloNome) + "|" + campoFormatado(widthPreco, tituloPreco) + "|" + campoFormatado(widthQuantidade, tituloQuantidade) + "|";

        String tituloTabela = "DASHBOARD PRODUTOS";
        int marginTitulo = linhaTituloProdutos.length() - (tituloTabela.length() + 6);
        int paddingTituloTabela = 6;
        int marginTituloTabela = marginTitulo/2;
        int bordasLateraisTituloTabela = 2;
        String linhaTituloTabela = " ".repeat(marginTituloTabela-2) + "|" + " ".repeat(paddingTituloTabela) + tituloTabela + " ".repeat(paddingTituloTabela) + "|" + " ".repeat(marginTituloTabela-2);
        String bordaTopTituloTabela = " ".repeat(marginTituloTabela-2) + "+ " + "-".repeat((tituloTabela.length() + (paddingTituloTabela*2) + bordasLateraisTituloTabela) - 4) + " +";

        String bordaTabela = "+ " + "-".repeat(linhaTituloProdutos.length()-4) + " +";
        String linhaDivisoriaProdutos = "-".repeat(linhaTituloProdutos.length());
        String linhaVazia = "|" + " ".repeat(widthCodigoProduto) + "|" + " ".repeat(widthNome) + "|" + " ".repeat(widthPreco) + "|" + " ".repeat(widthQuantidade) + "|";

        System.out.println(bordaTopTituloTabela);
        System.out.println(linhaTituloTabela);
        System.out.println(bordaTabela);
        System.out.println(linhaTituloProdutos);

        for(Map.Entry<String,Produto> entry : produtos.entrySet()) {
            System.out.println(linhaDivisoriaProdutos);
            System.out.println(linhaVazia);
            System.out.println(formatarCampoDadosProduto(widthCodigoProduto, widthNome, widthPreco, widthQuantidade, entry.getValue()));
            System.out.println(linhaVazia);
        }
        System.out.println(bordaTabela);
    }

    private static String campoFormatado(int widthCampo, String valorCampo) {

        int valorPadding = widthCampo - valorCampo.length();
        String padding = " ";

        return padding + valorCampo + padding.repeat(valorPadding - 1);
    }

    private static String formatarCampoDadosProduto(int widthCodigoProduto, int widthNome, int widthPreco, int widthQuantidade, Produto produto) {
        return "|" + campoFormatado(widthCodigoProduto, produto.getSku())
                + "|" + campoFormatado(widthNome, produto.getNome())
                + "|" + campoFormatado(widthPreco, String.valueOf(produto.getPreco()))
                + "|" + campoFormatado(widthQuantidade, String.valueOf(produto.getQuantidade()))
                + "|";
    }
}
