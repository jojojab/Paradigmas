package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public abstract class GameMode {

    public abstract boolean win(Linea board, int lastMove);

    public boolean checkVertical(Linea board, int lastMove) {
        int cuenta = 0;
        for (int i = 0; i < board.getBoard().get(lastMove).size(); i++) {
            if (board.getBoard().get(lastMove).get(i) == board.getFicha(lastMove)) {
                cuenta++;
            }
            else {
                cuenta = 0;
            }
            if (cuenta >= 4) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHorizontal(Linea board, int lastMove) {
        int cuenta = 0;
        for (int i = 0; i < board.getBase(); i++) {
            if (board.getBoard().get(i).size() > board.getBoard().get(lastMove).size() - 1) {
                if (board.getBoard().get(i).get(board.getBoard().get(lastMove).size() - 1) == board.getFicha(lastMove)) {
                    cuenta++;
                }
                else {
                    cuenta = 0;
                }
                if (cuenta >= 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonal(Linea board, int lastMove){
        return checkDiagonalRight(board, lastMove) || checkDiagonalLeft(board, lastMove);
    }

    public boolean checkDiagonalRight(Linea board, int lastMove){
        ArrayList<Character> diagonal = new ArrayList<>();
        int alturaNecesaria = board.getBoard().get(lastMove).size() - lastMove - 1;
        IntStream.range(0, board.getBase())
                .forEach(i -> {
                    if (alturaNecesaria + i >= 0) {
                        if (board.getBoard().get(i).size() - 1 >= alturaNecesaria + i) {
                            diagonal.add(board.getBoard().get(i).get(alturaNecesaria + i));
                        }
                        else {
                            diagonal.add('.');
                        }
                    }
                });

        int cuenta = 0;
        for (int i = 0; i < diagonal.size(); i++) {
            if (diagonal.get(i) == board.getFicha(lastMove)) {
                cuenta++;
            }
            else {
                cuenta = 0;
            }
            if (cuenta >= 4) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonalLeft(Linea board, int lastMove) {
        ArrayList<Character> diagonal = new ArrayList<>();
        int alturaNecesaria = board.getBoard().get(lastMove).size() - lastMove - 1;
        IntStream.range(0, board.getBase())
                .forEach(i -> {
                    if (alturaNecesaria + i >= 0) {
                        if (board.getBoard().get(board.getBase() - i - 1).size() - 1 >= alturaNecesaria + i) {
                            diagonal.add(board.getBoard().get(board.getBase() - i - 1).get(alturaNecesaria + i));
                        } else {
                            diagonal.add('.');
                        }
                    }
                });

        int cuenta = 0;
        for (int i = 0; i < diagonal.size(); i++) {
            if (diagonal.get(i) == board.getFicha(lastMove)) {
                cuenta++;
            } else {
                cuenta = 0;
            }
            if (cuenta >= 4) {
                return true;
            }
        }
        return false;
    }
}