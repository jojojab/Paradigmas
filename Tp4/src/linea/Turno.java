package linea;

public abstract class Turno {

    public abstract char playRedAt(int columna, Linea board);
    public abstract char playBlueAt(int columna, Linea board);
    public abstract int getTurno();
    public abstract int setTurno();
}
