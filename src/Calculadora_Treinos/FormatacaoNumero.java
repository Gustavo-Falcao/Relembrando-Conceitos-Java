package Calculadora_Treinos;


public class FormatacaoNumero {

    public static String FormatarDecimal(float valor, int casasDecimais) {

        String pattern = "%." + casasDecimais + "f";

        return String.format(pattern, valor);
    }
}
