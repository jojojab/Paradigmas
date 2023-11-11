package linea;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Linea {

    public GameMode actualGameMode;
    private int altura;
    private int base;
    private boolean win = false;
    private int turno = 0;

    private ArrayList<Turno> turnos = new ArrayList<Turno>();

    {
        turnos.add(new RedPlayer());
        turnos.add(new BluePlayer());
    }

    public static String noEsTurnoErrorDescription = "No es turno";

    public ArrayList<ArrayList<Character>> board;

    public Linea(int base, int altura, char gameMode) {
        board = new ArrayList<ArrayList<Character>>();
        this.base = base;
        this.altura = altura;
        this.actualGameMode = Command.commandFor(gameMode);
        for (int i = 0; i < base; i++) {
            ArrayList<Character> columna = new ArrayList<Character>();
            board.add(columna);
        }
    }


    public void playRedAt(int columna) {
        board.get(columna).add(turnos.get(turno).playRedAt(columna));
        setTurno();
        win = actualGameMode.win(this, columna);
    }

    public void playBlueAt(int columna) {
        board.get(columna).add(turnos.get(turno).playBlueAt(columna));
        setTurno();
        win = actualGameMode.win(this, columna);
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
        for (int i = 0; i < base; i++) {
            grid += i + " ";
        }
        grid += "||";
        return grid;
    }

//    public char buscarCoordenada(int x, int y) {
//        if (x >= 0 && x < base && y >= 0 && y < altura) {
//            if (board.get(x).size() > y)
//                return board.get(x).get(y);
//        }
//        return ' ';
//    }

    public char getFicha(int columna) {
        return board.get(columna).get(board.get(columna).size() - 1);
    }

    public void setTurno() {
        this.turno = turnos.get(turno).setTurno();
    }

    public int getTurno() {
        return turnos.get(turno).getTurno();
    }

    public boolean finished() {
        return win;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {return altura;}
}
