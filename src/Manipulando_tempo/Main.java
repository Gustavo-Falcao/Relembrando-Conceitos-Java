package Manipulando_tempo;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main ( String[] args) {

//        LocalDateTime bareDate = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm:ss");
//
//        String formattedDate = bareDate.format(formatter);
//
//        System.out.println(formattedDate);

        String tempo = "1:15:43";
        String regex = ":";
        String [] arrayString = tempo.split(regex);

        for(String s : arrayString) {
            System.out.println(s);
        }

    }

}
