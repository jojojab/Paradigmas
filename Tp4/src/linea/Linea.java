package linea;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Linea {

    private GameMode actualGameMode;
    private int altura;
    private int base;
    private boolean win = false;
    private Turno turnos;

    public static String noEsTurnoErrorDescription = "No es turno";

    private ArrayList<ArrayList<Character>> board;

    public Linea(int base, int altura, char gameMode) {
        board = new ArrayList<ArrayList<Character>>();
        this.base = base;
        this.altura = altura;
        if (base < 4 || altura < 4) {
            throw new RuntimeException("The board must be at least 4x4");
        }
        this.actualGameMode = Command.commandFor(gameMode);
        for (int i = 0; i < base; i++) {
            ArrayList<Character> columna = new ArrayList<Character>();
            board.add(columna);
        }
        this.board = board;
        this.turnos = new RedPlayer();
    }


    public void playRedAt(int columna) {
        this.turnos = turnos.playRedAt(columna, this);
        gameHasEnded();
    }

    public void playBlueAt(int columna) {
        this.turnos = turnos.playBlueAt(columna, this);
        gameHasEnded();
    }

    public void placePiece(int columna, char piece){
        if (columna < 0 || columna >= getBase()) {
            throw new RuntimeException("Columna fuera del tablero");
        }
        if (this.board.get(columna).size() == getAltura()) {
            throw new RuntimeException("Columna llena");
        }
        this.board.get(columna).add(piece);
        this.win = actualGameMode.win(this, columna);
    }

    public String show() {
        String grid = "";
        for (int i = altura - 1; i >= 0; i--) {
            grid += "|| ";
            for (int j = 0; j < base; j++) {
                if (board.get(j).size() > i) {
                    grid += board.get(j).get(i) + " ";
                } else {
                    grid += ". ";
                }
            }
            grid += "||\n";
        }
        grid += "|| ";
        grid += IntStream.range(0, base).mapToObj(Integer::toString).collect(Collectors.joining(" "));
        grid += " ||\n";
        return grid + turnos.status();
    }
    public char getFicha(int columna) {
        return board.get(columna).get(board.get(columna).size() - 1);
    }
    public boolean finished() {
        return turnos.isFinished();
    }

    public int getBase() {
        return base;
    }
    public int getAltura() {return altura;}

    public void gameHasEnded(){
        if (this.win){
            this.turnos = new GameFinished(getWinner());
        }
    }
    private String getWinner() {
        return turnos.winner();
    }

    public ArrayList<ArrayList<Character>> getBoard() {
        return this.board;
    }
}
