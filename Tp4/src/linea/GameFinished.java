package linea;

public class GameFinished extends Turno {

    private String winner;
    public GameFinished(String winner){
        this.winner = winner;
    }
    public Turno playRedAt(int columna, Linea board) {
        throw new RuntimeException("The game is over");
    }

    public Turno playBlueAt(int columna, Linea board) {
        throw new RuntimeException("The game is over");
    }
    public String status() {
        return "The game is over, the winner is: " + winner;
    }

    public String winner(){
        return winner;
    }

    public boolean isFinished(){
        return true;
    }
}
