package linea;

public abstract class Turno {

    public abstract Turno playRedAt(int columna, Linea board);
    public abstract Turno playBlueAt(int columna, Linea board);
    public abstract String status();
    public abstract boolean isFinished();
    public abstract String winner();
    public boolean fullBoard(Linea board){
        return board.getBoard().stream().allMatch(column -> column.size() == board.getAltura());
    }
}
