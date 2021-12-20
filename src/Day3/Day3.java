package Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public static int ejercicio1 () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day3/Day3"));
        int n=12;
        int [] positius = new int[n];
        int [] negatius = new int[n];
        int total;
        String linia;
        String mas = "";
        String menos = "";


        while ((linia = br.readLine()) != null) {
            String [] arrayAux = linia.split("");
            int i = 0;
            for (String s: arrayAux) {
               if (s.equals("1")) {
                   positius[i]++;
               } else {
                   negatius[i]++;
               }
               i++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (positius[i] > negatius[i]) {
                mas += "1";
                menos += "0";
            } else {
                mas += "0";
                menos += "1";
            }
        }

        BigInteger mayor = new BigInteger(mas, 2);
        BigInteger menor = new BigInteger(menos, 2);

        total = mayor.intValue() * menor.intValue();
        return total;
    }

    private static String getValor (List<String> datos, String seleccion, boolean mayor) {
        int positivo;
        int negativo;
        int contador = 0;
        List<String> arrayAux;
        String seleccionAux;

        while (datos.size() > 1) {
            positivo = 0;
            negativo = 0;

            for (String line : datos) {
                String [] lineArr = line.split("");
                String l = lineArr[contador];
                if (l.equals("1")) {
                    positivo++;
                } else {
                    negativo++;
                }
            }

            seleccionAux= seleccion;

            if (positivo > negativo) {
                if (mayor) {
                    seleccionAux = "1";
                } else {
                    seleccionAux = "0";
                }
            }
            if (positivo < negativo) {
                if (mayor) {
                    seleccionAux = "0";
                } else {
                    seleccionAux = "1";
                }
            }

            arrayAux = new ArrayList<>();

            for (String line: datos) {
                String [] lineArr = line.split("");
                String val = lineArr[contador];
                if (val.equals(seleccionAux)) {
                    arrayAux.add(line);
                }
            }
            datos = arrayAux;
            contador++;
        }
        return datos.get(0);
    }

    public static int ejercicio2 () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day3/Day3"));
        List<String> datos = new ArrayList<>();
        String linia;
        int total;

        while ((linia = br.readLine()) != null) {
            datos.add(linia);
        }

        String oxigeno = getValor(datos, "1", true);
        String co2 = getValor(datos, "0", false);

        BigInteger oxigeno_number = new BigInteger(oxigeno, 2);
        BigInteger co2_number = new BigInteger(co2, 2);

        total = oxigeno_number.intValue() * co2_number.intValue();

        return total;
    }
}
