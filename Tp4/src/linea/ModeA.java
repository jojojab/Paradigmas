package linea;

public class ModeA extends GameMode {

    public boolean mode(Linea game, int lastMove) {
        int cuenta = 0;
        char color = game.getFicha(lastMove);
        if (game.board.get(lastMove).size() >= 4) {
            for (int i = game.board.get(lastMove).size() - 1; i >= 0; i--) {
                if (game.board.get(lastMove).get(i) == color) {
                    cuenta++;
                } else {
                    break;
                }
                if (cuenta == 4) {
                    return true;
                }
            }
        }
        return false;
    }
}
