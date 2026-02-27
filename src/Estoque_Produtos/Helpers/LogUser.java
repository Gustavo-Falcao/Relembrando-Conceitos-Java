package Estoque_Produtos.Helpers;

import java.util.ArrayList;
import java.util.List;

public class LogUser {

    public static void logSucesso(String mensagem) {
        System.out.println("\n✅=>[" + mensagem + "]");
    }

    public static void logErro(String mensagem) {
        System.out.println("\n❌=>[" + mensagem + "]");
    }

    public static void logAtencao(String mensagem) {
        System.out.println("\n⚠️=>[" + mensagem + "]");
    }

}
