package Day4;

public class Tablero {
    int [] tablero = new int [25];
    int linia = 0;
    boolean hasWon = false;

    public void addLinia(String line) {
        String [] arrayAux = line.trim().split("[ ]+");
        int x = 0;
        for (String num: arrayAux) {
            tablero[linia * 5 + x] = Integer.parseInt(num);
            x++;
        }
        linia++;
    }


    public boolean addNum (int num) {
        int posicion = -1;
        boolean addNumero = false;
        int columna, fila;
        int contador;
        do{
            posicion = posicion +1;
            if(tablero[posicion] == num){
                tablero[posicion] = -num;
            }
        }while(tablero[posicion] != num && posicion + 1 < 25);

        if (posicion <= 24) {

            columna = posicion % 5;
            fila = Math.floorDiv(posicion, 5);

            contador = 0;
            for (int i = 0; i < 5; i++) {
                contador += tablero[fila * 5 + i] < 0 ? 1 : 0;
            }
            if (contador == 5) {
                addNumero = true;
            }else{
                contador = 0;
                for (int i = 0; i < 5; i++) {
                    contador += tablero[i * 5 + columna] < 0 ? 1 : 0;
                }
                if (contador == 5) {
                    addNumero = true;
                }else{
                    addNumero = false;
                }
            }
        }
        return addNumero;
    }
    public boolean addNum2 (int num) {
        boolean addNumero = false;
        int posicion = -1;
        int columna, fila;
        int count;
        if (!hasWon){
            do{
                posicion = posicion +1;
                if(tablero[posicion] == num){
                    if (num > 0) {
                        tablero[posicion] = -num;
                    } else {
                        tablero[posicion] = Integer.MIN_VALUE;
                    }
                }
            }while(tablero[posicion] != num && posicion + 1 < 25);

            if (posicion <= 24) {
                columna = posicion % 5;
                fila = Math.floorDiv(posicion, 5);

                count = 0;

                for (int i = 0; i < 5; i++) {
                    count += tablero[fila * 5 + i] < 0 ? 1 : 0;
                }
                if (count == 5) {
                    hasWon = true;
                    addNumero = true;
                }else {
                    count = 0;
                    for (int i = 0; i < 5; i++) {
                        count += tablero[i * 5 + columna] < 0 ? 1 : 0;
                    }
                    if (count == 5) {
                        hasWon = true;
                        addNumero= true;
                    }else{
                        addNumero =false;
                    }
                }
            }else{
                addNumero =false;
            }
        }
        return addNumero;
    }

    public int calTableroCompleto (int lastNum) {
        int contador = 0;
        int total;
        for (int i = 0; i < 25; i++) {
            if (tablero[i] > 0) {
                contador += tablero[i];
            }
        }
        total = contador * lastNum;
        return total;
    }
}
