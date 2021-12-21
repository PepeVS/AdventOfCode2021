import Day1.Day1;
import Day2.Day2;
import Day3.Day3;
import Day4.Day4;

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
                break;

            case 2 :
                exercice = vw.SeleccionarEjercicio();
                if(exercice == 1){
                    System.out.println(Day2.ejercicio1());
                }else{
                    System.out.println(Day2.ejercicio2());
                }
                break;
            case 3 :
                exercice = vw.SeleccionarEjercicio();
                if(exercice == 1){
                    System.out.println(Day3.ejercicio1());
                }else{
                    System.out.println(Day3.ejercicio2());
                }
                break;
            case 4:
                exercice = vw.SeleccionarEjercicio();
                if(exercice == 1){
                    Day4.ejercicio1();
                }else{
                    Day4.ejercicio2();
                }
                break;
            default :

        }
    }
}
