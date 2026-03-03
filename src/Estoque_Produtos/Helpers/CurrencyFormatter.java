package Estoque_Produtos.Helpers;

public class CurrencyFormatter {

    public static String currencyFormatter(double valor, int casasDecimais) {
        String pattern = "%." + casasDecimais + "f";

        return String.format(pattern, valor);
    }
}
