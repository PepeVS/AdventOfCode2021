package Day2;

import java.io.*;
import java.util.ArrayList;

public class Day2 {
    public static int ex1 () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day2/Day2"));

        int depth = 0;
        int horizontal = 0;
        int aim = 0;
        int acumulado;
        int total;
        String linia;

        while ((linia = br.readLine()) != null) {
            String[] arg = linia.split(" ");
            String cmd = arg[0];
            acumulado = Integer.parseInt(arg[1]);
            switch (cmd) {
                case "forward" -> {
                    horizontal += acumulado;
                    depth = aim;
                }
                case "down" -> aim += acumulado;
                case "up" -> aim -= acumulado;
            }
        }

        total = depth * horizontal;

        return total;
    }

    public static int ex2 () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day2/Day2"));

        int interior = 0;
        int horizontal = 0;
        int puntero = 0;
        int acumulado;
        int total;
        String linia;
        while ((linia = br.readLine()) != null) {
            String[] arg = linia.split(" ");
            String cmd = arg[0];
            acumulado = Integer.parseInt(arg[1]);
            switch (cmd) {
                case "forward" -> {
                    horizontal += acumulado;
                    interior += puntero * acumulado;
                }
                case "down" -> puntero += acumulado;
                case "up" -> puntero -= acumulado;
            }
        }

        total = interior * horizontal;

        return total;
    }
}
