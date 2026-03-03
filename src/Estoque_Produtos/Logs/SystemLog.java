package Estoque_Produtos.Logs;

import Estoque_Produtos.Helpers.DateHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SystemLog {

    public static List<String> logHistorico = new ArrayList<>();

    private static void logarHistorico(String mensagem) {
        String log = "[" + DateHandler.dataAtualFormatada() + "] " + mensagem;
        logHistorico.add(log);
        registrarLogArquivo(log);
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

    private static void registrarLogArquivo(String log) {
        try(FileWriter fileWriter = new FileWriter("src/Estoque_Produtos/Logs/log.txt", true)) {
            fileWriter.write(log+"\n");
        } catch (IOException e) {
            error("Falha ao tentar registrar log no arquivo");
            System.out.println(e.getMessage());
        }
    }

}
