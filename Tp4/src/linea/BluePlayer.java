package linea;

import static linea.Linea.noEsTurnoErrorDescription;

public class BluePlayer extends Turno {

    public char playBlueAt(int columna, Linea board) {
        if (columna < 0 || columna >= board.getBase()) {
            throw new RuntimeException("Columna fuera del tablero");
        }
        if (board.board.get(columna).size() == board.getAltura()) {
            throw new RuntimeException("Columna llena");
        }
        return 'O';
    }

    public char playRedAt(int columna, Linea board){
        throw new RuntimeException(noEsTurnoErrorDescription);
    }
    public int getTurno() {
        return 1;
    }

    public int setTurno() {
        return 0;
    }
}
