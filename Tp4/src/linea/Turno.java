package linea;

public abstract class Turno {

    public abstract char playRedAt(int columna);
    public abstract char playBlueAt(int columna);
    public abstract String getTurno();
    public abstract int setTurno();
}
