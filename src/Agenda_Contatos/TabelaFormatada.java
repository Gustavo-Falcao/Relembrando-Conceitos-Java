package Agenda_Contatos;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TabelaFormatada {

    public static void tabelaFormatadaForList(List<?> listaDados) {

        if(listaDados.isEmpty()) {
            System.out.println("TABELA FORMATADA: [Sem dados para mostrar]");
        } else {
            Class<?> classe = listaDados.getFirst().getClass();

            //System.out.println("Nome da classe da list => " + classe.getSimpleName());

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

                        String resultToString = String.valueOf(result);//convertendo o resultado para string

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

    //        System.out.println();
    //        System.out.println("Mostrando valores width padrao cada campo");
    //        for(Map.Entry<String,Integer> entry : defaultWidthCampos.entrySet()) {
    //            System.out.println(entry.getKey() + " => " + entry.getValue());
    //        }

            //adicionando padding aos width de cada campo
            for(Map.Entry<String,Integer> entry : defaultWidthCampos.entrySet()) {
                int valor = entry.getValue() + padding;
                entry.setValue(valor);
            }

    //        System.out.println("\nMostrando valores width padrao cada campo com a adicao de padding");
    //
    //        for(Map.Entry<String,Integer> entry : defaultWidthCampos.entrySet()) {
    //            System.out.println(entry.getKey() + " => " + entry.getValue());
    //        }

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

            //.out.println("Titulo dashboard abaixo com borda");
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
    }

    public static void tabelaFormatadaForMap(Map<?,?> mapDados) {
        Map.Entry<?, ?> primeiraEntrada = mapDados.entrySet().iterator().next();

        Class<?> classeValue = primeiraEntrada.getValue().getClass();

        //objetosEmMap
        List<Map<String,Object>> objetosEmMap = new ArrayList<>();
        //nomeCampos
        List<String> nomeCampos = new ArrayList<>();
        //defaultWidthCampos
        Map<String,Integer> defaultWidthCampos = new HashMap<>();
        //nomeMetodosGet
        Map<String,String> nomeMetodosGet = new HashMap<>();

        Field[] fields = classeValue.getDeclaredFields();

        for(Field field : fields) {
            String nomeCampo = field.getName();
            String nomeCampoTitulo = nomeCampo.substring(0,1).toUpperCase() + nomeCampo.substring(1);
            nomeCampos.add(nomeCampoTitulo);
            nomeMetodosGet.put(nomeCampoTitulo, "get"+nomeCampoTitulo);
        }

        int padding = 4;
        String nomeBaseVariavelWidthDefault = "widthDefault";

        for(String nomeCampo : nomeCampos) {
            defaultWidthCampos.put(nomeBaseVariavelWidthDefault+nomeCampo, nomeCampo.length() + padding);
        }

        for(Map.Entry<?,?> entry : mapDados.entrySet()) {
            Map<String,Object> objetoDado = new LinkedHashMap<>();
            for(String nomeCampo : nomeCampos) {
                try {
                    Method method = classeValue.getMethod(nomeMetodosGet.get(nomeCampo));
                    Object result = method.invoke(entry.getValue());

                    objetoDado.put(nomeCampo, result);

                    String resultToString =  String.valueOf(result);

                    String chavePadraoVariaveisDefaultWidth = nomeBaseVariavelWidthDefault+nomeCampo;

                    defaultWidthCampos.put(chavePadraoVariaveisDefaultWidth, Math.max(defaultWidthCampos.get(chavePadraoVariaveisDefaultWidth), resultToString.length()));

                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            objetosEmMap.add(objetoDado);
        }

        System.out.println();

        for(Map.Entry<String,Integer> entry : defaultWidthCampos.entrySet()) {
            int valorWidthDefaulComPadding = entry.getValue() + padding;
            entry.setValue(valorWidthDefaulComPadding);
        }

        StringBuilder linhaTitulo = new StringBuilder("|");

        for(String nomeTitulo : nomeCampos) {
            linhaTitulo.append(campoFormatoComPaddin(defaultWidthCampos.get(nomeBaseVariavelWidthDefault+nomeTitulo), nomeTitulo) + "|");
        }

        String borda = "+ " + "-".repeat(linhaTitulo.length()-4) + " +";
        String linhaSeparatoria = "|" + "-".repeat(linhaTitulo.length()-2) + "|";
        StringBuilder linhaVazia = new StringBuilder("|");

        for(String nomeCampo : nomeCampos) {
            String espaco = " ";
            linhaVazia.append(espaco.repeat(defaultWidthCampos.get(nomeBaseVariavelWidthDefault+nomeCampo)) + "|");
        }

        System.out.println(borda);
        System.out.println(linhaTitulo);
        System.out.println(borda);


        for(Map<String,Object> map : objetosEmMap) {
            StringBuilder linhaDado = new StringBuilder("|");

            for(Map.Entry<String,Object> entry : map.entrySet()) {
                String valueToString = entry.getValue().toString();
                linhaDado.append(campoFormatoComPaddin(defaultWidthCampos.get(nomeBaseVariavelWidthDefault+entry.getKey()), valueToString) + "|");
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

    private static String campoFormatoComPaddin(int widthPadraoCampo, String campo) {

        int valorPadding = widthPadraoCampo - campo.length();
        int paddingRight = valorPadding - 1;
        String padding = " ";
        return padding + campo + padding.repeat(paddingRight);
    }

}
