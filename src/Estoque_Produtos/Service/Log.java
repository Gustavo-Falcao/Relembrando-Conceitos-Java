package Estoque_Produtos.Service;

public class Log {

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
