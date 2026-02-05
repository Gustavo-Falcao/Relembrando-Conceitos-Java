package Agenda_Contatos;


import java.util.Scanner;

public class Main {

    public static void main(String [] args) {

        ContatoController contatoController = new ContatoController();
        int opcao;

        do {
            mostrarMenu();
            opcao = InputHelper.readInteger("Escolha uma opcao: ");
            handlerOpcao(opcao, contatoController);
        } while (opcao != 0);

    }

    public static void mostrarMenu() {
        System.out.println("\n\n\n+ ------------------------------------------ +");
        System.out.println("|         [1] - Criar novo Contato           |");
        System.out.println("|         [2] - Atualizar Contato            |");
        System.out.println("|         [3] - Deletar Contato              |");
        System.out.println("|         [4] - Buscar Contato               |");
        System.out.println("|         [5] - Listar todos os contatos     |");
        System.out.println("|         [0] - Sair                         |");
        System.out.println("+ ------------------------------------------ +");
    }

    public static void handlerOpcao(int opcao, ContatoController contatoController) {
        switch (opcao) {
            case 1 -> contatoController.criarContato();
            case 2 -> contatoController.atualizarContato();
            case 3 -> contatoController.deletarContato();
            case 4 -> contatoController.buscarContato();
            case 5 -> contatoController.mostrarContatos();
            case 0 -> System.out.println("Saindo...");
            default -> System.out.println("Escolha uma opcao existente");
        }
    }




}
