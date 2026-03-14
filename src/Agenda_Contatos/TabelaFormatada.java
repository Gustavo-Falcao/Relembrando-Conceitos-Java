package Agenda_Contatos;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TabelaFormatada {

    public static void tabelaFormatadaForList(List<?> listaDados) {

        Class<?> classe = listaDados.getFirst().getClass();

        System.out.println("Nome da classe da list => " + classe.getSimpleName());

        List<Map<String, Object>> objetosEmMap = new ArrayList<>();
        Map<String, Integer> defaultWidthCampos = new HashMap<>();
        List<String> nomeCampos = new ArrayList<>();
        Map<String,String> nomeMetodosGet = new HashMap<>();

        Field[] fields = classe.getDeclaredFields();

        //Adicionando campos da classe no array dos campos
        for(Field field : fields) {
            String nomeCampo = field.getName();
            String nomeCampoTitulo = nomeCampo.substring(0,1).toUpperCase() + nomeCampo.substring(1);
            nomeCampos.add(nomeCampoTitulo);
            nomeMetodosGet.put(nomeCampoTitulo, "get"+nomeCampoTitulo);
        }

        int padding = 4;
        //Inicializando variaveis para receber os valores default de comprimento para cada campo
        for(String nomeCampo : nomeCampos) {
            defaultWidthCampos.put("widthDefault" + nomeCampo, nomeCampo.length() + padding);
        }

        //Descobrindo os tamanhos default para cada campo
        for(Object dado : listaDados) {
            Map<String,Object> objetoDado = new LinkedHashMap<>();
            for(String nomeCampo : nomeCampos) {
                //Mostrar nome dos campos de cada objeto
                try {
                    Method method = classe.getMethod(nomeMetodosGet.get(nomeCampo));//pegando nome do metodo de acordo com o nome do campo
                    Object result = method.invoke(dado);//chamando o metodo para o objeto

                    objetoDado.put(nomeCampo, result);

                    String resultToString = (String) result;//convertendo o resultado para string

                    String chaveValoresDefaultWidth = "widthDefault" + nomeCampo;
                    //Adicionando o maior valor entre o valor que esta presente na variavel de comprimento padrao
                    //que corresponde ao campo do nomeCampo e o comprimento da string do proximo valor do mesmo campo
                    defaultWidthCampos.put(chaveValoresDefaultWidth, Math.max(defaultWidthCampos.get(chaveValoresDefaultWidth), resultToString.length()));

                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            objetosEmMap.add(objetoDado);
        }

        System.out.println();
        System.out.println("Mostrando valores width padrao cada campo");
        for(Map.Entry<String,Integer> entry : defaultWidthCampos.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        for(Map.Entry<String,Integer> entry : defaultWidthCampos.entrySet()) {
            int valor = entry.getValue() + 4;
            entry.setValue(valor);
        }

        System.out.println("\nMostrando valores width padrao cada campo com a adicao de padding");

        for(Map.Entry<String,Integer> entry : defaultWidthCampos.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        StringBuilder linhaTitulo = new StringBuilder("|");

        for(String nomeTitulo : nomeCampos) {
            linhaTitulo.append(campoFormatoComPaddin(defaultWidthCampos.get("widthDefault"+nomeTitulo), nomeTitulo) + "|");
        }

        String borda = "+ " + "-".repeat(linhaTitulo.length()-4) + " +";
        String linhaSeparatoria = "|" + "-".repeat(linhaTitulo.length()-2) + "|";
        StringBuilder linhaVazia = new StringBuilder("|");

        for(String nomeCampo : nomeCampos) {
            String espaco = " ";
            linhaVazia.append(espaco.repeat(defaultWidthCampos.get("widthDefault"+nomeCampo)) + "|");
        }

        System.out.println("Titulo dashboard abaixo com borda");
        System.out.println(borda);
        System.out.println(linhaTitulo);
        System.out.println(borda);

        for(Map<String,Object> map : objetosEmMap) {
            StringBuilder linhaDado = new StringBuilder("|");

            for(Map.Entry<String,Object> entry : map.entrySet()) {
                String valueToString = entry.getValue().toString();
                linhaDado.append(campoFormatoComPaddin(defaultWidthCampos.get("widthDefault"+entry.getKey()), valueToString) + "|");
            }
            System.out.println(linhaVazia);
            System.out.println(linhaDado);
            System.out.println(linhaVazia);
            if(objetosEmMap.indexOf(map) == objetosEmMap.size()-1) {
                System.out.println(borda);
            } else {
                System.out.println(linhaSeparatoria);
            }
        }
    }

    public static void tabelaFormatadaForMap(Map<?,?> mapDados) {
        Map.Entry<?, ?> primeiraEntrada = mapDados.entrySet().iterator().next();

        Class<?> classeKey = primeiraEntrada.getKey().getClass();
        Class<?> classeValue = primeiraEntrada.getValue().getClass();

        System.out.println("Classe key => " + classeKey.getSimpleName() + " | Classe value => " + classeValue.getSimpleName());

        //Class<?> classeKey = mapDados.ge
    }

    private static String campoFormatoComPaddin(int widthPadraoCampo, String campo) {

        int valorPadding = widthPadraoCampo - campo.length();
        int paddingRight = valorPadding - 1;
        String padding = " ";
        return padding + campo + padding.repeat(paddingRight);
    }

}
