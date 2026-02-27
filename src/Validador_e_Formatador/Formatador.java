package Validador_e_Formatador;

public class Formatador {

    public static String formatarCpf(String cpf) {
        StringBuilder sb = new StringBuilder(cpf);

        sb.insert(3, '.');
        sb.insert(7, '.');
        sb.insert(11, '-');

        return sb.toString();
    }

    public static String formatarTelefone(String telefone) {
        StringBuilder sb = new StringBuilder(telefone);
        //(41) 99988-7766
        sb.insert(0, "(");
        sb.insert(3, ")");
        sb.insert(4, " ");
        sb.insert(10, "-");

        return sb.toString();
    }
}
