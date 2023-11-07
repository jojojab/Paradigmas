package linea;

public class Linea {

    private final char modoJuego;
    private int altura;
    private int base;
    char[][] grid;
    public boolean win = false;
    private String turno;
    public static String noEsTurnoErrorDescription = "No es turno";

    public Linea(int base, int altura, char modoJuego) {
        this.base = base;
        this.altura = altura;
        this.grid = new char[altura][base];
        this.modoJuego = modoJuego;
    }

    public boolean finished() {
        return win;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public boolean turnoRed() {
        return getTurno() == "red";
    }

    public boolean turnoBlue() {
        return getTurno() == "blue";
    }

    public void playRedAt(int prompt) {
        if (turnoRed()) {
            setTurno("blue");
        } else {
            throw new Error(noEsTurnoErrorDescription);
        }
    }

    public void playBlueAt(int prompt) {
        if (turnoBlue()) {
            setTurno("red");
        } else {
            throw new Error(noEsTurnoErrorDescription);
        }
    }

    public String show() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }


        private String getTurno() {
            return turno;
        }

    }
}
