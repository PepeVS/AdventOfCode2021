package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day1 {

    private static final ArrayList<String> listDay1Aux = new ArrayList<>();
    private static final ArrayList<Integer> listDay1 = new ArrayList<>();

    public static void read () throws IOException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        archivo = new File ("src/Day1/Day1");
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);

        // Lectura del fichero
        String linea;
        while((linea=br.readLine())!=null) {
            listDay1Aux.add(linea);
        }

        for(String s : listDay1Aux) listDay1.add(Integer.valueOf(s));

    }

    public static int ejercio1 () {
        int aux = 0;
        for (int i = 0; i < listDay1.size(); i++) {
            if (i > 0) {
                if (listDay1.get(i) > listDay1.get(i - 1)){
                    aux++;
                }
            }
        }
        return aux;
    }

    public static void ejercio2 () {
        int countIncrease = 0;
        int[] lastNumbers = new int[3];
        int[] currentNumbers = new int[3];
        int startCount = 0;

        for (int i = 0; i < listDay1.size(); i++) {
            if (startCount < 3) {
                if (startCount > 0) {
                    currentNumbers[startCount - 1] = listDay1.get(i);
                }
                lastNumbers[startCount] = listDay1.get(i);
                startCount++;
                continue;
            }

            currentNumbers[2] = listDay1.get(i);

            int curr = 0;
            int last = 0;
            for (int j = 0; j < 3; j++) {
                last += lastNumbers[j];
                curr += currentNumbers[j];
            }

            if (curr > last) {
                countIncrease++;
            }

            lastNumbers = Arrays.copyOf(currentNumbers, 3);

            for (int j = 0; j < 2; j++) {
                currentNumbers[j] = currentNumbers[j + 1];
            }
        }
        System.out.println(countIncrease);

    }

}