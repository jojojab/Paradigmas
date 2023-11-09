package linea;

import java.util.ArrayList;

public class Linea {

    private final char modoJuego;
    private int altura;
    private int base;
    public boolean win = false;
    private int turno = 0;
    private ArrayList<Turno> turnos = new ArrayList<Turno>();
    {
        turnos.add(new RedPlayer());
        turnos.add(new BluePlayer());
    }
    public static String noEsTurnoErrorDescription = "No es turno";

    public ArrayList<ArrayList<Character>> board;

    public Linea(int base, int altura, char modoJuego) {
        board = new ArrayList<ArrayList<Character>>();
        this.base = base;
        this.altura = altura;
        this.modoJuego = modoJuego;
        for (int i = 0; i < base; i++){
            ArrayList<Character> columna = new ArrayList<Character>();
            board.add(columna);
        }
        this.board = board;
    }


    public void playRedAt(int columna) {
        board.get(columna).add(turnos.get(turno).playRedAt(columna));
        setTurno();
        win = new ModeB().mode(this, columna);
    }

    public void playBlueAt(int columna) {
        board.get(columna).add(turnos.get(turno).playBlueAt(columna));
        setTurno();
        win = new ModeB().mode(this, columna);
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
        return grid;
    }

    public char getFicha(int columna) {
        return board.get(columna).get(board.get(columna).size() - 1);
    }
    public void setTurno() {
        this.turno = turnos.get(turno).setTurno();
    }

    private String getTurno() {
        return turnos.get(turno).getTurno();
    }

    public boolean finished() {
        return win;
    }

    public int getBase() {
        return base;
    }
}