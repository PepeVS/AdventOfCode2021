import java.util.Scanner;

public class View {
    public int SeleccionarDia(){
        int day;

        Scanner input = new Scanner(System.in);

        System.out.printf("Seleccione un dia: ");
        day = input.nextInt();


        return day;
    }

    public int SeleccionarEjercicio(){
        int ejercicio;

        Scanner input = new Scanner(System.in);

        System.out.printf("Seleccione un ejercicio: ");
        ejercicio = input.nextInt();


        return ejercicio;
    }
}
