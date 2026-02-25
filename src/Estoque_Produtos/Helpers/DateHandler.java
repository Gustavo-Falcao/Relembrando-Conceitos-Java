package Estoque_Produtos.Helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHandler {

    public static String dataAtualFormatada() {
        LocalDateTime dataAtual = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return dataAtual.format(dateTimeFormatter);
    }
}
