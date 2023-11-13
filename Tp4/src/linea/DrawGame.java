package linea;

public class DrawGame extends Turno{

    public Turno playRedAt(int columna, Linea board) {
        throw new RuntimeException("The game is over, its a draw");
    }

    public Turno playBlueAt(int columna, Linea board) {
        throw new RuntimeException("The game is over, its a draw");
    }

    public String status() {
        return "The game is over, its a draw";
    }

    public boolean isFinished(){
        return true;
    }

    public String winner() {
        return null;
    }
}
