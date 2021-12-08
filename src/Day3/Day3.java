package Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public static void binaryDiagnostic () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day3/Day3"));
        int [] positiveBitsCount = new int[12];
        int [] negativeBitsCount = new int[12];
        String line;
        while ((line = br.readLine()) != null) {
            String [] lineArr = line.split("");
            int i = 0;
            for (String s: lineArr) {
               if (s.equals("1")) {
                   positiveBitsCount[i]++;
               } else {
                   negativeBitsCount[i]++;
               }
               i++;
            }
        }

        String most = "";
        String least = "";

        for (int i = 0; i < positiveBitsCount.length; i++) {
            if (positiveBitsCount[i] > negativeBitsCount[i]) {
                most += "1";
                least += "0";
            } else {
                most += "0";
                least += "1";
            }
        }

        BigInteger mostNumber = new BigInteger(most, 2);
        BigInteger leastNumber = new BigInteger(least, 2);

        System.out.println(mostNumber.intValue() * leastNumber.intValue());

    }

    private static String getValue (List<String> newData, String selectCritera, boolean keepMost) {
        int i = 0;

        while (newData.size() > 1) {
            int positive = 0;
            int negative = 0;

            for (String line : newData) {
                String [] lineArr = line.split("");
                String s = lineArr[i];
                if (s.equals("1")) {
                    positive++;
                } else {
                    negative++;
                }
            }

            String keepCriteria = selectCritera;

            if (positive > negative) {
                if (keepMost) {
                    keepCriteria = "1";
                } else {
                    keepCriteria = "0";
                }
            } else if (positive < negative) {
                if (keepMost) {
                    keepCriteria = "0";
                } else {
                    keepCriteria = "1";
                }
            }

            List<String> keepList = new ArrayList<>();

            for (String line: newData) {
                String [] lineArr = line.split("");
                String val = lineArr[i];
                if (val.equals(keepCriteria )) {
                    keepList.add(line);
                }
            }

            newData = keepList;
            i++;
        }
        return newData.get(0);

    }

    public static void binaryDiagnosticPartTwo () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Day3/Day3"));
        List<String> newData = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            newData.add(line);
        }

        String oxygenGenerator = getValue(newData, "1", true);
        String CO2scrubber = getValue(newData, "0", false);

        BigInteger oxygenGeneratorNumber = new BigInteger(oxygenGenerator, 2);
        BigInteger CO2scrubberNumber = new BigInteger(CO2scrubber, 2);

        System.out.println(oxygenGeneratorNumber.intValue() * CO2scrubberNumber.intValue());
    }
}
