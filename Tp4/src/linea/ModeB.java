package linea;

public class ModeB extends GameMode{

    public boolean mode(Linea game, int lastMove){
        int cuenta = 0;
        char color = game.getFicha(lastMove);
        int altura = game.board.get(lastMove).size() - 1;
        if ( lastMove >= 3 ){
            for (int i = lastMove; i >= 0; i--){
                if (game.board.get(i).size() > altura){
                    if (game.board.get(i).get(altura) == color){
                        cuenta++;
                    } else {
                        break;
                    }
                    if (cuenta == 4){
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        if ( lastMove <= game.getBase() - 4 ){
            for (int i = lastMove; i < game.getBase(); i++){
                if (game.board.get(i).size() > altura){
                    if (game.board.get(i).get(altura) == color){
                        cuenta++;
                    } else {
                        break;
                    }
                    if (cuenta == 4){
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
