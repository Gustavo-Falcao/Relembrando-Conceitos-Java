package Validador_e_Formatador;

import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();
            System.out.print("Escola uma opcao: ");
            opcao = Integer.parseInt(scanner.nextLine());
            handlerOpcaoMenu(opcao);
        } while (opcao != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n\n");
        System.out.println("      + ----------------------- +");
        System.out.println("      | Validaddor e Formatador |");
        System.out.println("+ ------------------------------------- +");
        System.out.println("|              [1]- Nome                |");
        System.out.println("|              [2]- CPF                 |");
        System.out.println("|              [3]- e-mail              |");
        System.out.println("|              [4]- telefone            |");
        System.out.println("|              [0]- Sair                |");
        System.out.println("+ ------------------------------------- +");
    }

    public static void handlerOpcaoMenu(int opcao) {
        switch (opcao) {
            case 1:
                System.out.print("Digite o nome: ");
                String nome = scanner.nextLine();
                Validador.validarNome(nome);
                break;
            case 2:
                System.out.print("Digite o cpf: ");
                String cpf = scanner.nextLine();
                String resultCpf = Validador.validarCpf(cpf);
                if(!resultCpf.isEmpty()) System.out.println("Seu cpf é válido -> " + resultCpf);
                break;
            case 3:
                System.out.print("Digite o email: ");
                String email = scanner.nextLine();
                if(Validador.validarEmail(email)) System.out.println("Seu email é válido -> " + email);
                break;
            case 4:
                System.out.print("Ditite o telefone com ou sem mascara: ");
                String telefone = scanner.nextLine();
                String resultTelefone = Validador.validarTelefone(telefone);
                if(!resultTelefone.isEmpty()) {
                    System.out.println("Seu telefone é válido -> " + resultTelefone);
                }
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Escolha uma opção válida!!");
                break;
        }
    }
}
