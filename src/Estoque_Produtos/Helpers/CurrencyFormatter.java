package Estoque_Produtos.Helpers;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

    public static String currencyFormatter(double valor, int casasDecimais) {
        String pattern = "R$ %." + casasDecimais + "f";

        return String.format(pattern, valor);
    }
}
