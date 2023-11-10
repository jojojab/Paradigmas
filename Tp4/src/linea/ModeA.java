package linea;

public class ModeA extends GameMode {

    public boolean win(Linea game, int lastMove) {
//        int cuenta = 0;
//        char color = game.getFicha(lastMove);
//        int altura = game.board.get(lastMove).size() - 1;
//
//        if (game.board.get(lastMove).size() >= 4) {
//            for (int i = altura; i >= 0; i--) {
//                if (game.board.get(lastMove).get(i) == color) {
//                    cuenta++;
//                } else {
//                    break;
//                }
//                if (cuenta == 4) {
//                    return true;
//                }
//            }
//        }
//
//        if ( lastMove >= 3 ){
//            for (int i = lastMove; i >= 0; i--){
//                if (game.board.get(i).size() > altura){
//                    if (game.board.get(i).get(altura) == color){
//                        cuenta++;
//                    } else {
//                        break;
//                    }
//                    if (cuenta == 4){
//                        return true;
//                    }
//                } else {
//                    break;
//                }
//            }
//        }
//
//        if ( lastMove <= game.getBase() - 4 ){
//            for (int i = lastMove; i < game.getBase(); i++){
//                if (game.board.get(i).size() > altura){
//                    if (game.board.get(i).get(altura) == color){
//                        cuenta++;
//                    } else {
//                        break;
//                    }
//                    if (cuenta == 4){
//                        return true;
//                    }
//                } else {
//                    break;
//                }
//            }
//        }
//
//        return false;
//    }
        return checkVertical(game, lastMove) || checkHorizontal(game, lastMove);
    }
}
