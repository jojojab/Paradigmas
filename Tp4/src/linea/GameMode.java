package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public abstract class GameMode {

    public abstract boolean win(Linea board, int lastMove);

    public boolean checkVertical(Linea board, int lastMove) {
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

    public boolean checkDiagonal(Linea board, int lastMove){
        return checkDiagonalRight(board, lastMove) || checkDiagonalLeft(board, lastMove);
    }

    public boolean checkDiagonalRight(Linea board, int lastMove){
        ArrayList<Character> diagonal = new ArrayList<>();
        int alturaNecesaria = board.board.get(lastMove).size() - lastMove - 1;
        IntStream.range(0, board.getBase())
                .forEach(i -> {
                    if (alturaNecesaria + i >= 0) {
                        if (board.board.get(i).size() - 1 >= alturaNecesaria + i) {
                            diagonal.add(board.board.get(i).get(alturaNecesaria + i));
                        }
                        else {
                            diagonal.add('.');
                        }
                    }
                });
        return IntStream.range(0, diagonal.size())
                .filter(i -> diagonal.get(i) == board.getFicha(lastMove))
                .count() >= 4;
    }

    public boolean checkDiagonalLeft(Linea board, int lastMove){
        ArrayList<Character> diagonal = new ArrayList<>();
        int alturaNecesaria = board.board.get(lastMove).size() - lastMove - 1;
        IntStream.range(0, board.getBase())
                .forEach(i -> {
                    if (alturaNecesaria + i >= 0) {
                        if (board.board.get(board.getBase() - i - 1).size() - 1 >= alturaNecesaria + i) {
                            diagonal.add(board.board.get(board.getBase() - i - 1).get(alturaNecesaria + i));
                        }
                        else {
                            diagonal.add('.');
                        }
                    }
                });
        return IntStream.range(0, diagonal.size())
                .filter(i -> diagonal.get(i) == board.getFicha(lastMove))
                .count() >= 4;
    }
}