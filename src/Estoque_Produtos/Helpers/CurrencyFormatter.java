package Estoque_Produtos.Helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

    public static String currencyFormatter(double valor) {
        Locale localePtBr = new Locale("pt", "BR");

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localePtBr);

        BigDecimal bigDecimal = BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_UP);

        return numberFormat.format(bigDecimal).replace('\u00A0', ' ');
    }
}
