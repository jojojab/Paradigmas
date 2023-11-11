package linea;

import static linea.Linea.noEsTurnoErrorDescription;

public class RedPlayer extends Turno {

    public char playRedAt(int columna) {
        return 'X';
    }

    public char playBlueAt(int columna){
        throw new RuntimeException(noEsTurnoErrorDescription);
    }
    public int getTurno() {
        return 0;
    }

    public int setTurno() {
        return 1;
    }
}
