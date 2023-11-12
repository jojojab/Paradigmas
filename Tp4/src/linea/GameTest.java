package linea;

import org.junit.Test;

import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static linea.Linea.noEsTurnoErrorDescription;


public class GameTest {

    @Test
    public void emptyBoardWhenCreated(){
        Linea game = new Linea(4, 4, 'A');
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| . . . . ||\n|| . . . . ||\n|| 0 1 2 3 ||");
        assertFalse(game.finished());
    }

    @Test
    public void canNotPlaceAPieceOutsideTheBoard() {
        Linea game = new Linea(4, 4, 'A');
        assertThrowsLike(() -> game.playRedAt(4), "Columna fuera del tablero");
    }

    @Test
    public void bluePlayerCanNotStart(){
        Linea game = new Linea(4, 4, 'A');
        assertThrowsLike(() -> game.playBlueAt(0), noEsTurnoErrorDescription);
    }

    @Test
    public void cannotMakeTwoConsecutivesPlays() {
        Linea game = new Linea(4, 4, 'A');
        game.playRedAt(0);
        assertThrowsLike(() -> game.playRedAt(1), noEsTurnoErrorDescription);
    }

    @Test
    public void somePlays(){
        Linea game = new Linea(4, 4, 'A');
        game = playList(game, List.of(0, 0, 1, 1));
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O . . ||\n|| X X . . ||\n|| 0 1 2 3 ||");
        assertFalse(game.finished());
    }

    @Test
    public void canNotPlaceAPieceInAFullColumn(){
        Linea game = new Linea(4, 4, 'A');
        Linea board = playList(game, List.of(0, 0, 0, 0));
        assertThrowsLike(() -> board.playRedAt(0), "Columna llena");
    }

    @Test
    public void redPlayerWinsWithFourInColumnModeA(){
        Linea game = new Linea(4, 4, 'A');
        game = playList(game, List.of(0, 1, 0, 1, 0, 1, 0));
        assertEquals(game.show(), "|| X . . . ||\n|| X O . . ||\n|| X O . . ||\n|| X O . . ||\n|| 0 1 2 3 ||");
        assertTrue(game.finished());
    }

    @Test
    public void redPlayerWinsWithFourInRowModeA(){
        Linea game = new Linea(4, 4, 'A');
        game = playList(game, List.of(0, 0, 1, 1, 2, 2, 3));
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O O . ||\n|| X X X X ||\n|| 0 1 2 3 ||");
        assertTrue(game.finished());
    }

    @Test
    public void redPlayerWinsWithFourInDiagonalModeB(){
        Linea game = new Linea(4, 4, 'B');
        game = playList(game, List.of(0, 1, 1, 2, 2, 3, 2, 3, 3, 0, 3));
        assertEquals(game.show(), "|| . . . X ||\n|| . . X X ||\n|| O X X O ||\n|| X O O O ||\n|| 0 1 2 3 ||");
        assertTrue(game.finished());
    }

    @Test
    public void canWinWithFourInRowModeC() {
        Linea game = new Linea(4, 4, 'C');
        game = playList(game, List.of(0, 0, 1, 1, 2, 2, 3));
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O O . ||\n|| X X X X ||\n|| 0 1 2 3 ||");
        assertTrue(game.finished());
    }

    @Test
    public void canWinWIthFourInColumnModeC() {
        Linea game = new Linea(4, 4, 'C');
        game = playList(game, List.of(0, 1, 0, 1, 0, 1, 0));
        assertEquals(game.show(), "|| X . . . ||\n|| X O . . ||\n|| X O . . ||\n|| X O . . ||\n|| 0 1 2 3 ||");
        assertTrue(game.finished());
    }

    @Test
    public void canWInWIthFourInDiagonalModeC() {
        Linea game = new Linea(4, 4, 'C');
        game = playList(game, List.of(0, 1, 1, 2, 2, 3, 2, 3, 3, 0, 3));
        assertEquals(game.show(), "|| . . . X ||\n|| . . X X ||\n|| O X X O ||\n|| X O O O ||\n|| 0 1 2 3 ||    ");
        assertTrue(game.finished());
    }

    private void assertThrowsLike( Executable executable, String message) {
        assertEquals( message,
                assertThrows( RuntimeException.class, executable ).getMessage() );
    }

    public Linea playList(Linea game, List<Integer> plays) {
        plays.forEach(i -> {
            if (game.getTurno() == 0) {
                game.playRedAt(i);
            } else {
                game.playBlueAt(i);
            }
        });
        return game;
    }

}
