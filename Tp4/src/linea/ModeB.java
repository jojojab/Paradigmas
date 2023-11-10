package linea;

public class ModeB extends GameMode{

    public boolean win(Linea game, int lastMove){
        return checkDiagonal(game, lastMove);
    }
}
