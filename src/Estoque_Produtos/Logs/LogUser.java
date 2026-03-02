package Estoque_Produtos.Logs;

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
