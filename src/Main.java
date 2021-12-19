import Day1.Day1;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        int day, exercice;
        View vw = new View();
        day = vw.SeleccionarDia();

        switch (day){
            case 1 :
                Day1.leer();
                exercice = vw.SeleccionarEjercicio();
                if(exercice == 1){
                    System.out.println(Day1.ejercio1());
                }else{
                    System.out.println(Day1.ejercio2());
                }
                break; // break es opcional

            case 2 :
                // Declaraciones
                break; // break es opcional
            default :

        }
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
