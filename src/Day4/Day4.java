package Day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static void ejercicio1 () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day4/Day4"));
        int num = 0;
        String linia;
        String numeros = "";
        List<Tablero> tableros = new ArrayList<>();
        Tablero currentBoard = null;

        while ((linia = br.readLine()) != null) {
            if (num == 0) {
                numeros = linia;
                num++;
                continue;
            }
            if (linia.isBlank()) {
                if (currentBoard != null) {
                    tableros.add(currentBoard);
                }
                currentBoard = new Tablero();
                continue;
            }

            currentBoard.addLinia(linia);

            num++;
        }

        if (currentBoard != null) {
            tableros.add(currentBoard);
        }

        for (String number: numeros.split(",")) {
            int numInt = Integer.parseInt(number);
            for (Tablero tablero: tableros) {
                if (tablero.addNum(numInt)) {
                    System.out.println(tablero.calTableroCompleto(numInt));
                    System.exit(0);
                }
            }
        }

        System.exit(-1);

    }

    public static void ejercicio2 () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day4/Day4"));

        int lineNum = 0;
        String line;
        String numbers = "";
        List<Tablero> tableros = new ArrayList<>();
        Tablero tableroActual = null;
        Tablero tableroCompleto = null;
        int numero = 0;
        int tablerosCompletos = 0;

        while ((line = br.readLine()) != null) {
            if (lineNum == 0) {
                numbers = line;
                lineNum++;
                continue;
            }
            if (line.isBlank()) {
                if (tableroActual != null) {
                    tableros.add(tableroActual);
                }
                tableroActual = new Tablero();
                continue;
            }

            tableroActual.addLinia(line);

            lineNum++;
        }

        if (tableroActual != null) {
            tableros.add(tableroActual);

            for (String num: numbers.split(",")) {
                int numInt = Integer.parseInt(num);
                for (Tablero tablero: tableros) {
                    if (tablero.addNum2(numInt)) {
                        tableroCompleto = tablero;
                        numero = numInt;
                        tablerosCompletos++;
                        if (tablerosCompletos == tableros.size()) {

                        }
                    }
                }
            }
        } else {
            for (String num: numbers.split(",")) {
                int numInt = Integer.parseInt(num);
                for (Tablero tablero: tableros) {
                    if (tablero.addNum2(numInt)) {
                        tableroCompleto = tablero;
                        numero = numInt;
                        tablerosCompletos++;
                        if (tablerosCompletos == tableros.size()) {

                        }
                    }
                }
            }
        }


        if (tableroCompleto != null) {
            System.out.println(tableroCompleto.calTableroCompleto(numero));
        }

        System.exit(-1);
    }
}
