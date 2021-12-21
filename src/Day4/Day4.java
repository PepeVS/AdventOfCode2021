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
            for (Tablero b: tableros) {
                if (b.addNum(numInt)) {
                    System.out.println(b.caloWinningBoard(numInt));
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
        List<Tablero> boards = new ArrayList<>();
        Tablero currentBoard = null;

        while ((line = br.readLine()) != null) {
            if (lineNum == 0) {
                numbers = line;
                lineNum++;
                continue;
            }
            if (line.isBlank()) {
                if (currentBoard != null) {
                    boards.add(currentBoard);
                }
                currentBoard = new Tablero();
                continue;
            }

            currentBoard.addLinia(line);

            lineNum++;
        }

        if (currentBoard != null) {
            boards.add(currentBoard);
        }

        Tablero winningBoard = null;
        int winningNum = 0;
        int numOfWinningBoards = 0;

        outerloop:
        for (String num: numbers.split(",")) {
            int numInt = Integer.parseInt(num);
            for (Tablero b: boards) {
                if (b.addNum2(numInt)) {
                    winningBoard = b;
                    winningNum = numInt;
                    numOfWinningBoards++;
                    if (numOfWinningBoards == boards.size()) {
                        break outerloop;
                    }
                }
            }
        }

        if (winningBoard != null) {
            System.out.println(winningBoard.caloWinningBoard(winningNum));
        }

        System.exit(-1);
    }
}
