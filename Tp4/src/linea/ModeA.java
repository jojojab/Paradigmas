package linea;

public class ModeA extends GameMode {

    public boolean win(Linea game, int lastMove) {
        return checkVertical(game, lastMove) || checkHorizontal(game, lastMove);
    }
}
