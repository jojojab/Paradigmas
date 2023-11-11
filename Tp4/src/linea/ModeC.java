package linea;

public class ModeC extends GameMode{

    public boolean win(Linea game, int lastMove){
        return checkVertical(game, lastMove) || checkHorizontal(game, lastMove) || checkDiagonal(game, lastMove);
    }
}
