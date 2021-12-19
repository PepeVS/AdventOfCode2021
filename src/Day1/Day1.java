package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day1 {

    private static final ArrayList<Integer> listDay1 = new ArrayList<>();
    private static final ArrayList<String> listDay1Aux = new ArrayList<>();

    public static void leer() throws IOException {
        File file;
        FileReader fr;
        BufferedReader br;
        String linea;

        //cargamos el fichero para trabajar con el
        file = new File ("src/Day1/Day1");
        fr = new FileReader (file);
        br = new BufferedReader(fr);


        //Leemos el fichero
        while((linea=br.readLine())!=null) {
            listDay1Aux.add(linea);
        }

        for(String s : listDay1Aux) {
            listDay1.add(Integer.valueOf(s));
        }

    }

    public static int ejercio1 () {
        int aux = 0;
        int i;
        for (i = 0; i < listDay1.size(); i++) {
            if (i > 0) {
                if (listDay1.get(i) > listDay1.get(i-1)){
                    aux++;
                }
            }
        }
        return aux;
    }

    public static int ejercio2 () {
        int aumento = 0;
        int[] ultimos = new int[3];
        int[] actuales = new int[3];
        int contador = 0;

        for (int i = 0; i < listDay1.size(); i++) {
            if (contador < 3) {
                if (contador > 0) {
                    actuales[contador - 1] = listDay1.get(i);
                }
                ultimos[contador] = listDay1.get(i);
                contador++;
            }

            actuales[2] = listDay1.get(i);

            int act = 0;
            int ult = 0;
            for (int j = 0; j < 3; j++) {
                ult += ultimos[j];
                act += actuales[j];
            }

            if (act > ult) {
                aumento++;
            }

            ultimos = Arrays.copyOf(actuales, 3);

            for (int j = 0; j < 2; j++) {
                actuales[j] = actuales[j+1];
            }
        }
        return aumento;

    }

}