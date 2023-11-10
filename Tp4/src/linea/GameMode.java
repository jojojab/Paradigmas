package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public abstract class GameMode {

    public abstract boolean win(Linea board, int lastMove);

    public boolean checkVertical(Linea board, int lastMove) {
//        int cuenta = 0;
//        char color = board.getFicha(lastMove);
//        int altura = board.board.get(lastMove).size() - 1;
//
//        if (board.board.get(lastMove).size() >= 4) {
//            for (int i = altura; i >= 0; i--) {
//                if (board.board.get(lastMove).get(i) == color) {
//                    cuenta++;
//                } else {
//                    break;
//                }
//                if (cuenta == 4) {
//                    return true;
//                }
//            }
//        }


        return IntStream.range(0, board.board.get(lastMove).size())
                .filter(i -> board.board.get(lastMove).get(i) == board.getFicha(lastMove))
                .count() >= 4;
    }

    public boolean checkHorizontal(Linea board, int lastMove) {
        return IntStream.range(0, board.getBase())
                .filter(i -> board.board.get(i).size() > board.board.get(lastMove).size() - 1)
                .filter(i -> board.board.get(i).get(board.board.get(lastMove).size() - 1) == board.getFicha(lastMove))
                .count() >= 4;
    }

    public boolean checkDiagonal(Linea board, int lastMove) {
        return IntStream.range(0, board.getBase())
                .anyMatch(r -> IntStream.range(0, board.getBase())
                        .filter(h -> board.buscarCoordenada(r + h, h) == board.getFicha(lastMove))
                        .count() >= 4)
                || IntStream.range(0, board.getBase()).anyMatch(r -> IntStream.range(0, board.getBase())
                .filter(h -> board.buscarCoordenada(r + h, board.getBase() - h - 1) == board.getFicha(lastMove)).count() >= 4);
    }
}