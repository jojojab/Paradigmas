package linea;

import org.junit.Test;

import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static linea.Linea.noEsTurnoErrorDescription;


public class GameTest {

    @Test
    public void emptyBoardWhenCreated(){
        Linea game = new Linea(4, 4, 'A');
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| . . . . ||\n|| . . . . ||\n|| 0 1 2 3 ||");
    }

    @Test
    public void somePlays(){
        Linea game = new Linea(4, 4, 'A');
        game = playList(game, List.of(0, 0, 1, 1));
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O . . ||\n|| X X . . ||\n|| 0 1 2 3 ||");
    }

    @Test
    public void cannotMakeTwoConsecutivesPlays() {
        Linea game = new Linea(4, 4, 'A');
        game.playRedAt(0);
        assertThrowsLike(() -> game.playRedAt(1), noEsTurnoErrorDescription);
    }

    @Test
    public void bluePlayerCanNotStart(){
        Linea game = new Linea(4, 4, 'A');
        assertThrowsLike(() -> game.playBlueAt(0), noEsTurnoErrorDescription);
    }

//    @Test
//    public void redPlayerCanNotPlayInFullColumn(){
//        Linea game = new Linea(4, 4, 'A');
//        game.playRedAt(0);
//        game.playBlueAt(0);
//        game.playRedAt(0);
//        game.playBlueAt(0);
//        assertThrowsLike(() -> game.playRedAt(0), "Columna llena");
//    }
    // hay que chequear esto con una excepcion, o queda asi? se gasta el movimiento pero no se altera la tabla

    @Test
    public void redPlayerWinsWithFourInColumnModeA(){
        Linea game = new Linea(4, 4, 'A');
        game = playList(game, List.of(0, 1, 0, 1, 0, 1, 0));
        assertEquals(game.show(), "|| X . . . ||\n|| X O . . ||\n|| X O . . ||\n|| X O . . ||\n|| 0 1 2 3 ||");
        assertEquals(game.finished(), true);
    }

    @Test
    public void redPlayerWinsWithFourInRowModeA(){
        Linea game = new Linea(4, 4, 'A');
        game = playList(game, List.of(0, 0, 1, 1, 2, 2, 3));
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O O . ||\n|| X X X X ||\n|| 0 1 2 3 ||");
        assertEquals(game.finished(), true);
    }

    @Test
    public void redPlayerWinsWithFourInDiagonalModeB(){
        Linea game = new Linea(4, 4, 'B');
        game = playList(game, List.of(0, 1, 1, 2, 2, 3, 2, 3, 3, 0, 3));
        assertEquals(game.show(), "|| . . . X ||\n|| . . X X ||\n|| O X X O ||\n|| X O O O ||\n|| 0 1 2 3 ||");
        assertEquals(game.finished(), true);
    }

    @Test
    public void canWinWithFourInRowModeC() {
        Linea game = new Linea(4, 4, 'C');
        game = playList(game, List.of(0, 0, 1, 1, 2, 2, 3));
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O O . ||\n|| X X X X ||\n|| 0 1 2 3 ||");
        assertEquals(game.finished(), true);
    }

    @Test
    public void canWinWIthFourInColumnModeC() {
        Linea game = new Linea(4, 4, 'C');
        game = playList(game, List.of(0, 1, 0, 1, 0, 1, 0));
        assertEquals(game.show(), "|| X . . . ||\n|| X O . . ||\n|| X O . . ||\n|| X O . . ||\n|| 0 1 2 3 ||");
        assertEquals(game.finished(), true);
    }

    @Test
    public void canWInWIthFourInDiagonalModeC() {
        Linea game = new Linea(4, 4, 'C');
        game = playList(game, List.of(0, 1, 1, 2, 2, 3, 2, 3, 3, 0, 3));
        assertEquals(game.show(), "|| . . . X ||\n|| . . X X ||\n|| O X X O ||\n|| X O O O ||\n|| 0 1 2 3 ||");
        assertEquals(game.finished(), true);
    }

    @Test
    public void gameDoesNotFinishIfAddingMoreThanBoardHeight() {
        Linea game = new Linea(4, 4, 'A');
        game = playList(game, List.of(0, 0, 0, 0, 0, 0, 0));
        assertEquals(game.show(), "|| O . . . ||\n|| X . . . ||\n|| O . . . ||\n|| X . . . ||\n|| 0 1 2 3 ||");
        assertEquals(game.finished(), false);
    }

//    @Test
//    public void gameThrowExceptionWhenTryingToPlayOutOfBounds() {
//        Linea game = new Linea(4, 4, 'A');
//        assertThrowsLike(() -> game.playRedAt(4), "Columna fuera de rango");
//        assertThrowsLike(() -> game.playBlueAt(-1), "Columna fuera de rango");
    }

    private void assertThrowsLike( Executable executable, String message) {
        assertEquals( message,
                assertThrows( RuntimeException.class, executable ).getMessage() );
    }

    public Linea playList(Linea game, List<Integer> plays) {
        plays.stream().forEach(i -> {
            if (game.getTurno() == 0) {
                game.playRedAt(i);
            } else {
                game.playBlueAt(i);
            }
        });
        return game;
    }

}
