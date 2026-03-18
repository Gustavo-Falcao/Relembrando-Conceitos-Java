package Estoque_Produtos.View;

import Estoque_Produtos.Logs.LogUser;
import Estoque_Produtos.Logs.SystemLog;

public class AppView {

    public static void mostrarMenuPrincipal() {
        System.out.println("\n\n+ ----------------------------------------------------------- +");
        System.out.println("|        [1] - Cadastrar produto                              |");
        System.out.println("|        [2] - Entrada de estoque                             |");
        System.out.println("|        [3] - Saida de estoque                               |");
        System.out.println("|        [4] - Consultar produto                              |");
        System.out.println("|        [5] - Listar todos os produtos                       |");
        System.out.println("|        [6] - Remover produto                                |");
        System.out.println("|        [7] - Listar historico acoes                         |");
        System.out.println("|        [8] - Consultar quantidade total estoque             |");
        System.out.println("|        [9] - Consultar valor total estoque                  |");
        System.out.println("|        [10] - Consultar valor medio estoque                 |");
        System.out.println("|        [11] - Consultar quantidade produtos cadastrados     |");
        System.out.println("|        [12] - Listar quantidade estoque por categoria       |");
        System.out.println("|        [13] - Listar valor total por categoria              |");
        System.out.println("|        [14] - Listar estoque baixo                          |");
        System.out.println("|        [15] - Listar produtos sem estoque                   |");
        System.out.println("|        [16] - Listar top 3 produtos mais caros              |");
        System.out.println("|        [17] - Listar produtos ordenado por nome             |");
        System.out.println("|        [18] - Listar produtos ordenado por preco crescente  |");
        System.out.println("|        [19] - Listar produtos ordenado por preco decrescente|");
        System.out.println("|        [20] - Exportar dados para csv                       |");
        System.out.println("|        [0] - Sair                                           |");
        System.out.println("+ ---------------------------------------------------------- +");
    }

    public static void handlerMenuPrincipal(int opcao) {
        switch (opcao) {
            case 1 -> ProdutoView.cadastrarProduto();
            case 2 -> ProdutoView.addEstoque();
            case 3 -> ProdutoView.saidaEstoque();
            case 4 -> ProdutoView.consultarProduto();
            case 5 -> ProdutoView.mostrarProdutos();
            case 6 -> ProdutoView.deletarProduto();
            case 7 -> historicoAcoes();
            case 8 -> ProdutoView.consultarQuantidadeTotalEstoque();
            case 9 -> ProdutoView.consultarValorTotalEstoque();
            case 10 -> ProdutoView.consultarValorMedioEstoque();
            case 11 -> ProdutoView.consultarQuantidadeProdutosCadastrados();
            case 20 -> ProdutoView.exportarDadosCsv();
            case 0 -> System.out.println("Saindo...");
            default -> LogUser.logAtencao("Escolha uma opcao valida!!");
        }
    }

    private static void historicoAcoes() {
        System.out.println("\n\n");
        System.out.println("<< Histórico acoes >>");

        if(SystemLog.logHistorico.size() < 1) {
            LogUser.logAtencao("Nenhuma ação realizada ainda!!");
        } else {
            for(String historico : SystemLog.logHistorico) {
                System.out.println(historico);
            }
        }
    }
}
