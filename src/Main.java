import Day1.Day1;
import Day2.Day2;
import Day3.Day3;
import Day4.Day4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        int day, exercice;
        View vw = new View();

        day = vw.SeleccionarDia();

        switch (day){
            case 1 :
                exercice = vw.SeleccionarEjercicio();
                if(exercice == 1){
                    Day1.read();
                    System.out.println(Day1.ejercio1());
                }else{

                }
                break; // break es opcional

            case 2 :
                // Declaraciones
                break; // break es opcional
            default :

        }

        //Day1.ejercio2();
        //Day2.dive();
        //Day2.divPartTwo();
        //Day3.binaryDiagnostic();
        //Day3.binaryDiagnosticPartTwo();
        //Day4.giantSquid();
        //Day4.giantSquidPartTwo();
        //new Day5();
        //new Day6();
        //new Day7();
        //new Day8();

    }
}
