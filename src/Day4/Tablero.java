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
        boolean breack = false;
        do{
            posicion++;
            if(tablero[posicion] == num){
                tablero[posicion] = -num;
            }
        }while(tablero[posicion] != num);
        if (posicion > 24) return false;

        int column = posicion % 5;
        int row = Math.floorDiv(posicion, 5);

        int count = 0;
        for (int i = 0; i < 5; i++) {
            count += tablero[row * 5 + i] < 0 ? 1 : 0;
        }
        if (count == 5) {
            return true;
        }

        count = 0;
        for (int i = 0; i < 5; i++) {
            count += tablero[i * 5 + column] < 0 ? 1 : 0;
        }
        if (count == 5) {
            return true;
        }

        return false;
    }
    public boolean addNum2 (int num) {
        if (hasWon) return false;
        int pos = 0;
        for (int b: tablero){
            if (b == num) {
                if (num > 0) {
                    tablero[pos] = -num;
                } else {
                    tablero[pos] = Integer.MIN_VALUE;
                }
                break;
            }
            pos++;
        }

        if (pos > 24) return false;

        int column = pos % 5;
        int row = Math.floorDiv(pos, 5);

        int count = 0;
        for (int i = 0; i < 5; i++) {
            count += tablero[row * 5 + i] < 0 ? 1 : 0;
        }
        if (count == 5) {
            hasWon = true;
            return true;
        }

        count = 0;
        for (int i = 0; i < 5; i++) {
            count += tablero[i * 5 + column] < 0 ? 1 : 0;
        }
        if (count == 5) {
            hasWon = true;
            return true;
        }

        return false;
    }

    public int caloWinningBoard (int lastNum) {
        int count = 0;
        for (int i = 0; i < 25; i++) {
            if (tablero[i] > 0) {
                count += tablero[i];
            }
        }
        return count * lastNum;
    }
}
