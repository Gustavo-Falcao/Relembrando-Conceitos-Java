package Calculadora_Treinos;

public class FormatacaoTempo {

    public static String FormatarTempoEstimado(int tempHoras, int tempMinutos, int tempSegundos) {

        String tempHorasString = tempHoras >= 10 ? String.valueOf(tempHoras) : "0" + tempHoras;
        String tempMinutosString = tempMinutos >= 10 ? String.valueOf(tempMinutos) : "0" + tempMinutos;
        String tempSegundosString = tempSegundos >= 10 ? String.valueOf(tempSegundos) : "0" + tempSegundos;

        return tempHorasString + ":" + tempMinutosString + ":" + tempSegundosString;

    }
}
