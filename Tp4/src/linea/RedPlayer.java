package linea;

import static linea.Linea.noEsTurnoErrorDescription;

public class RedPlayer extends Turno {

    public Turno playRedAt(int columna, Linea board) {
        board.placePiece(columna, 'X');
        return this.fullBoard(board) ? new DrawGame() : new BluePlayer();
    }
    public Turno playBlueAt(int columna, Linea board){
        throw new RuntimeException(noEsTurnoErrorDescription);
    }
    public String status() {
        return "It's Red's turn (X):";
    }

    public String winner(){
        return "Blue (O)";
    }

    public boolean isFinished(){
        return false;
    }
}
