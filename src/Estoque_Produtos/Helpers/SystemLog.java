package Estoque_Produtos.Helpers;

import java.util.ArrayList;
import java.util.List;

public class SystemLog {

    public static List<String> logHistorico = new ArrayList<>();

    private static void logarHistorico(String mensagem) {
        logHistorico.add("[" + DateHandler.dataAtualFormatada() + "] " + mensagem);
    }

    public static void info(String mensagem) {
        logarHistorico("INFO " + mensagem);
    }

    public static void warn(String mensagem) {
        logarHistorico("WARN " + mensagem);
    }

    public static void error(String mensagem) {
        logarHistorico("ERROR " + mensagem);
    }


}
