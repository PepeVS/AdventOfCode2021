package Day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static void giantSquid () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day4/Day4"));

        int lineNum = 0;
        String line;
        String numbers = "";
        List<BingoBoard> boards = new ArrayList<>();
        BingoBoard currentBoard = null;

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
                currentBoard = new BingoBoard();
                continue;
            }

            currentBoard.addLine(line);

            lineNum++;
        }

        if (currentBoard != null) {
            boards.add(currentBoard);
        }

        for (String num: numbers.split(",")) {
            int numInt = Integer.parseInt(num);
            for (BingoBoard b: boards) {
                if (b.addNum(numInt)) {
                    System.out.println(b.caloWinningBoard(numInt));
                    System.exit(0);
                }
            }
        }

        System.exit(-1);

    }

    public static void giantSquidPartTwo () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day4/Day4"));

        int lineNum = 0;
        String line;
        String numbers = "";
        List<BingoBoard> boards = new ArrayList<>();
        BingoBoard currentBoard = null;

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
                currentBoard = new BingoBoard();
                continue;
            }

            currentBoard.addLine(line);

            lineNum++;
        }

        if (currentBoard != null) {
            boards.add(currentBoard);
        }

        BingoBoard winningBoard = null;
        int winningNum = 0;
        int numOfWinningBoards = 0;

        outerloop:
        for (String num: numbers.split(",")) {
            int numInt = Integer.parseInt(num);
            for (BingoBoard b: boards) {
                if (b.addNum2(numInt)) {
                    winningBoard = b;
                    winningNum = numInt;
                    numOfWinningBoards++;
                    if (numOfWinningBoards == boards.size()) {
                        break outerloop;
                    }
                    //System.out.println(b.caloWinningBoard(numInt));
                    //System.exit(0);
                }
            }
        }

        if (winningBoard != null) {
            System.out.println(winningBoard.caloWinningBoard(winningNum));
        }

        System.exit(-1);
    }
}
