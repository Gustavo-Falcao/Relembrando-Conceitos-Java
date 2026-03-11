package Agenda_Contatos;

import java.lang.reflect.Type;
import java.util.List;

public class TabelaFormatada {

    public static <T> void tabelaFormatada(List<T> listaDados) {

    // Fazer uma lista de Map, onde cada Map é um objeto temporário
    // Descrobrir o nome dos atributos e guardar como chave no Map que representa um objeto
    // Para cada chave guardar os valores correspondentes
//
//        int lengthId = contatos.getFirst().getId().length();
//
//        System.out.println("Maior length de id => " + lengthId);
//
//        int maiorLengthNome = 0;
//        int maiorLenghTelefone = 0;
//        int maiorLenghtEmail = 0;
//
//        for(Contato c : contatos) {
//            if(maiorLengthNome < c.getNome().length()) maiorLengthNome = c.getNome().length();
//
//            if(maiorLenghTelefone < c.getTelefone().length()) maiorLenghTelefone = c.getTelefone().length();
//
//            if(maiorLenghtEmail < c.getEmail().length()) maiorLenghtEmail = c.getEmail().length();
//        }
//
//        int widthPadraoId = lengthId + 4;
//        int widthPadraoNome = maiorLengthNome + 4;
//        int widthPadraoTelefone = maiorLenghTelefone + 4;
//        int widthPadraoEmail = maiorLenghtEmail + 4;
//
//        //Saber o width total do campo
//        //Subtrair pelo comprimento da string Id_Contato
//        //Dividir o valor subtraido por 2
//        //O resultado será os dois padding de cada lado do valor
//
//        String tituloId = "Id_Contato";
//        String tituloNome = "Nome";
//        String tituloTelefone = "Telefone";
//        String tituloEmail = "Email";
//
//
//        String linhaTitulo = "|" + campoFormatoComPaddin(widthPadraoId, tituloId) + "|" + campoFormatoComPaddin(widthPadraoNome, tituloNome) + "|" + campoFormatoComPaddin(widthPadraoTelefone, tituloTelefone) + "|" + campoFormatoComPaddin(widthPadraoEmail, tituloEmail) + "|";
//
//
//        String titulo = "CONTATOS CADASTRADOS";
//        int tamanhoMarginTitulo = linhaTitulo.length() - titulo.length();
//        int paddingTitulo = 4;
//        int marginLados = tamanhoMarginTitulo/2;
//        int bordasLateraisTitulo = 2;
//
//        String tituloTabela =  " ".repeat(marginLados - (paddingTitulo*2)) + "|" + " ".repeat(4) + titulo + " ".repeat(4) + "|" + " ".repeat(marginLados - (paddingTitulo*2));
//        System.out.println("Tamanho completo length titulo -> " + (titulo.length() + paddingTitulo*2) );
//        String borderTitulo = " ".repeat(marginLados - (paddingTitulo*2)) + "+ " + "-".repeat((titulo.length() + (paddingTitulo*2) + bordasLateraisTitulo) - 4) + " +";
//        String lengthTitulo = "+ " + "-".repeat((titulo.length() + (paddingTitulo*2)) - 4) + " +";
//        System.out.println("Tamanho completo borda titulo -> " + lengthTitulo.length());
//
//        String border = "+ " + "-".repeat(linhaTitulo.length()-4) + " +";
//
//        String borderBottom = "-".repeat(linhaTitulo.length());
//
//        String linhaVazia = "|" + " ".repeat(widthPadraoId) + "|" + " ".repeat(widthPadraoNome) + "|" + " ".repeat(widthPadraoTelefone) + "|" + " ".repeat(widthPadraoEmail) + "|";
//
//        System.out.println("\n\n\n");
//        System.out.println(borderTitulo);
//        System.out.println(tituloTabela);
//        System.out.println(border);
//        System.out.println(linhaTitulo);
//
//
//        for(Contato c : contatos) {
//            System.out.println(borderBottom);
//            System.out.println(linhaVazia);
//            System.out.println(formatarCampoUsuario(widthPadraoId, widthPadraoNome, widthPadraoTelefone, widthPadraoEmail, c));
//            System.out.println(linhaVazia);
//        }
//        System.out.println(border);
    }

//    private static String campoFormatoComPaddin(int widthPadraoCampo, String campo) {
//
//        //System.out.println("\n\nWidth padrao campo ->" + widthPadraoCampo);
//        //System.out.println("Lengh para " + campo + campo.length());
//
//        int valorPadding = widthPadraoCampo - campo.length();
//        //System.out.println("Valor padding -> " + valorPadding);
//        int paddingRight = valorPadding - 1;
//        //System.out.println("Padding cada lado -> " + paddingCadaLado);
//        String padding = " ";
//        return padding + campo + padding.repeat(paddingRight);
//    }
//
//    private static String formatarCampoUsuario(int widthPadraoId, int widthPadraoNome, int widthPadraoTelefone, int widthPadraoEmail, Contato contato) {
//        return   "|" + campoFormatoComPaddin(widthPadraoId, contato.getId())
//                + "|" + campoFormatoComPaddin(widthPadraoNome, contato.getNome())
//                + "|" + campoFormatoComPaddin(widthPadraoTelefone, contato.getTelefone())
//                + "|" + campoFormatoComPaddin(widthPadraoEmail, contato.getEmail())
//                + "|";
//
//    }
}
