package linea;

import static linea.Linea.noEsTurnoErrorDescription;

public class BluePlayer extends Turno {

    public char playBlueAt(int columna) {
        return 'O';
    }

    public char playRedAt(int columna){
        throw new RuntimeException(noEsTurnoErrorDescription);
    }
    public String getTurno() {
        return "blue";
    }

    public int setTurno() {
        return 0;
    }
}
