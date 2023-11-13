package linea;

import static linea.Linea.noEsTurnoErrorDescription;

public class BluePlayer extends Turno {

    public Turno playBlueAt(int columna, Linea board) {
        board.placePiece(columna, 'O');
        return this.fullBoard(board) ? new DrawGame() : new RedPlayer();
    }

    public Turno playRedAt(int columna, Linea board){
        throw new RuntimeException(noEsTurnoErrorDescription);
    }
    public String status() {
        return "It's Blue's turn (O):";
    }

    public String winner(){
        return "Red (X)";
    }

    public boolean isFinished(){
        return false;
    }
}
