package Validador_e_Formatador;

public class Validador {

    public static boolean validarNome(String entrada) {
        //zerar espaços depois e antes do nome
        String nomeSemEspacoesEmBranco = entrada.trim();

        //Nome nao pode ser vazio e não pode ultrapassar 60 caracteres
        if(nomeSemEspacoesEmBranco.length() < 1 || nomeSemEspacoesEmBranco.length() > 60 || nomeSemEspacoesEmBranco == null) {
            System.out.println("Quantidade de caracteres invalida para o nome!!");
            return false;
        }

        return true;
    }

    public static boolean validarCpf(String cpfEntrada) {
        String cpfSemEspacosEmBranco = cpfEntrada.trim();

        if(cpfSemEspacosEmBranco.length() < 0) {
            System.out.println("Quantidade de entrada invalido para cpf");
            return false;
        }

        String regexTiraMascara = "[-.\s]+";

        String cpfSemMascara = cpfSemEspacosEmBranco.replaceAll(regexTiraMascara, "");

        if(cpfSemMascara.length() != 11 || cpfSemMascara == null) {
            System.out.println("Quantidade de numeros invalida para cpf");
            return false;
        }

        if(isTodosDigitosCpfIguais(cpfSemMascara)) {
            System.out.println("Todos os digitos são iguais, entrada invalida!!");
            return false;
        }

        return true;
    }

    public static boolean isTodosDigitosCpfIguais(String cpf) {
        char primeiroDigitoCpf = cpf.charAt(0);
        for(var i = 1; i < cpf.length(); i++) {
            if(cpf.charAt(i) != primeiroDigitoCpf){
                System.out.println("Encontrou um digito diferente!!");
                return false;
            }
        }
        return true;
     }
}
