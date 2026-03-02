package Estoque_Produtos.Helpers;

public class Currency_Formatter {

    public static String currencyFormatter(double valor, int casasDecimais) {
        String pattern = "%." + casasDecimais + "f";

        return String.format(pattern, valor);
    }
}
