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

    public static String validarCpf(String cpfEntrada) {
        String cpfSemEspacosEmBranco = cpfEntrada.trim();

        if(cpfSemEspacosEmBranco.length() < 0) {
            System.out.println("Quantidade de entrada invalido para cpf");
            return "";
        }

        String regexTiraMascara = "\\D+";

        String cpfSemMascara = cpfSemEspacosEmBranco.replaceAll(regexTiraMascara, "");

        if(cpfSemMascara.length() != 11 || cpfSemMascara == null) {
            System.out.println("Quantidade de numeros invalida para cpf");
            return "";
        }

        if(isTodosDigitosCpfIguais(cpfSemMascara)) {
            System.out.println("Todos os digitos são iguais, entrada invalida!!");
            return "";
        }

        return Formatador.formatarCpf(cpfSemMascara);
    }

    public static boolean isTodosDigitosCpfIguais(String cpf) {
        char primeiroDigitoCpf = cpf.charAt(0);
        for(var i = 1; i < cpf.length(); i++) {
            if(cpf.charAt(i) != primeiroDigitoCpf){
                return false;
            }
        }
        return true;
     }

    public static boolean validarEmail(String email) {
        String emailSemEspacosEmBranco = email.trim();

        if(emailSemEspacosEmBranco.isEmpty()) {
            System.out.println("Formato inválido, sem valor");
            return false;
        }

        String emailNormalizado = emailSemEspacosEmBranco.toLowerCase();
        String regex = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";

        if(!emailNormalizado.matches(regex)) {
            System.out.println("Formato de email invalido!!");
            return false;
        }

        if(emailNormalizado.contains("..")) {
            System.out.println("Formato de email invalido!! -> Caiu nos dois pontos consecutivos!!");
            return false;
        }
        return true;
     }

    public static String validarTelefone(String telefone) {
        String telefoneSemEspacosEmBranco = telefone.trim();

        if (telefoneSemEspacosEmBranco.isEmpty()) {
            System.out.println("Formato invalido telefone, sem valores");
            return "";
        }

        String telefoneSemMascara = telefoneSemEspacosEmBranco.replaceAll("\\D+", "");

        if(telefoneSemMascara.length() != 11) {
            System.out.println("Valor invalido para telefone. -> Telefone tem que ter 11 digitos");
            return "";
        }

        String regex = "^[1-9]{2}9[0-9]{8}$";
        if(!telefoneSemMascara.matches(regex)) {
            System.out.println("Formato de telefone invalido!!");
            return "";
        }

        return Formatador.formatarTelefone(telefoneSemMascara);
    }
}
