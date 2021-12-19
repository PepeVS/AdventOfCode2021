package Day2;

import java.io.*;
import java.util.ArrayList;

public class Day2 {
    public static void dive () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day2/Day2"));

        int depth = 0;
        int horizontal = 0;
        int aim = 0;

        String line;
        while ((line = br.readLine()) != null) {
            String[] arg = line.split(" ");
            String cmd = arg[0];
            int amount = Integer.parseInt(arg[1]);
            switch (cmd) {
                case "forward" -> {
                    horizontal += amount;
                    depth = aim;
                }
                case "down" -> aim += amount;
                case "up" -> aim -= amount;
            }
        }
        System.out.println("horizontal: " + horizontal);
        System.out.println("depth: " + depth);

        System.out.println(depth * horizontal);
    }

    public static void divPartTwo () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day2/Day2"));

        int depth = 0;
        int horizontal = 0;
        int aim = 0;

        String line;
        while ((line = br.readLine()) != null) {
            //for (String line : data.split("\n")) {
            String[] arg = line.split(" ");
            String cmd = arg[0];
            int amount = Integer.parseInt(arg[1]);
            switch (cmd) {
                case "forward" -> {
                    horizontal += amount;
                    depth += aim * amount;
                }
                case "down" -> aim += amount;
                case "up" -> aim -= amount;
            }
        }
        System.out.println("horizontal: " + horizontal);
        System.out.println("depth: " + depth);

        System.out.println(depth * horizontal);
    }
}
