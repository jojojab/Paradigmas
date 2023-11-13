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
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| . . . . ||\n|| . . . . ||\n|| 0 1 2 3 ||\nIt's Red's turn (X):");
        assertFalse(game.finished());
    }

    @Test
    public void canNotCreateBoardWithHeightLessThan4(){
        assertThrowsLike(() -> new Linea(4, 3, 'B'), "The board must be at least 4x4");
    }

    @Test
        public void canNotCreateBoardWithWidthLessThan4(){
        assertThrowsLike(() -> new Linea(3, 4, 'C'), "The board must be at least 4x4");
    }

    @Test
    public void canNotPlaceAPieceOutsideTheBoard() {
        Linea game = new Linea(4, 4, 'A');
        assertThrowsLike(() -> game.playRedAt(4), "Columna fuera del tablero");
    }

    @Test
    public void gameDoesNotStartWithAnInvalidGameMode() {
        assertThrowsLike(() -> new Linea(7, 6, 'D'), "No value present");
    }

    @Test
    public void bluePlayerCanNotStart(){
        Linea game = lineaSpec44A();
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
        Linea game = playList(lineaSpec44A(), List.of(0, 0, 1, 1));
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O . . ||\n|| X X . . ||\n|| 0 1 2 3 ||\nIt's Red's turn (X):");
        assertFalse(game.finished());
    }

    @Test
    public void canNotPlaceAPieceInAFullColumn(){
        Linea game = playList(lineaSpec44A(), List.of(0, 0, 0, 0));
        assertThrowsLike(() -> game.playRedAt(0), "Columna llena");
    }

    @Test
    public void redPlayerWinsWithFourInColumnModeA(){
        Linea game = playList(lineaSpec44A(), List.of(0, 1, 0, 1, 0, 1, 0));
        assertEquals(game.show(), "|| X . . . ||\n|| X O . . ||\n|| X O . . ||\n|| X O . . ||\n|| 0 1 2 3 ||\nThe game is over, the winner is: Red (X)");
        assertTrue(game.finished());
    }

    @Test
    public void redPlayerWinsWithFourInRowModeA(){
        Linea game = playList(lineaSpec44A(), List.of(0, 0, 1, 1, 2, 2, 3));
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O O . ||\n|| X X X X ||\n|| 0 1 2 3 ||\nThe game is over, the winner is: Red (X)");
        assertTrue(game.finished());
    }

    @Test
    public void redPlayerWinsWithFourInDiagonalModeB(){
        Linea game = new Linea(4, 4, 'B');
        game = playList(game, List.of(0, 1, 1, 2, 2, 3, 2, 3, 3, 0, 3));
        assertEquals(game.show(), "|| . . . X ||\n|| . . X X ||\n|| O X X O ||\n|| X O O O ||\n|| 0 1 2 3 ||\nThe game is over, the winner is: Red (X)");
        assertTrue(game.finished());
    }

    @Test
    public void canWinWithFourInRowModeC() {
        Linea game = new Linea(4, 4, 'C');
        game = playList(game, List.of(0, 0, 1, 1, 2, 2, 3));
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O O . ||\n|| X X X X ||\n|| 0 1 2 3 ||\nThe game is over, the winner is: Red (X)");
        assertTrue(game.finished());
    }

    @Test
    public void canWinWithFourInColumnModeC() {
        Linea game = new Linea(4, 4, 'C');
        game = playList(game, List.of(0, 1, 2, 1, 0, 1, 0, 1));
        assertEquals(game.show(), "|| . O . . ||\n|| X O . . ||\n|| X O . . ||\n|| X O X . ||\n|| 0 1 2 3 ||\nThe game is over, the winner is: Blue (O)");
        assertTrue(game.finished());
    }

    @Test
    public void canWinWithFourInDiagonalModeC() {
        Linea game = new Linea(4, 4, 'C');
        game = playList(game, List.of(0, 1, 1, 2, 2, 3, 2, 3, 3, 0, 3));
        assertEquals(game.show(), "|| . . . X ||\n|| . . X X ||\n|| O X X O ||\n|| X O O O ||\n|| 0 1 2 3 ||\nThe game is over, the winner is: Red (X)");
        assertTrue(game.finished());
    }

    @Test
    public void drawMatch(){
        Linea game = playList(lineaSpec44A(), List.of(0,0,0,0,1,2,1,1,1,2,2,2,3,3,3,3));
        assertTrue(game.finished());
    }

    @Test
    public void tryingToPlayInADrawFinishedGame() {
        Linea game = playList(lineaSpec44A(), List.of(0,0,0,0,1,2,1,1,1,2,2,2,3,3,3,3));
        Linea finalGame = game;
        assertThrowsLike(() -> finalGame.playRedAt(0), drawMatchMessage());
    }

    @Test
    public void tryingToPlayInAWonFinishedGame() {
        Linea game = playList(lineaSpec44A(), List.of(0, 1, 0, 1, 0, 1, 0));
        Linea finalGame = game;
        assertThrowsLike(() -> finalGame.playBlueAt(0), theGameIsOverMessage());
    }

    @Test
    public void winnerIsCorrectWhenGameIsFinished() {
        Linea game = playList(lineaSpec44A(), List.of(0, 1, 0, 1, 0, 1, 2, 1));
        assertEquals(game.getWinner(), "Blue (O)");
    }

    private static Linea lineaSpec44A() {
        Linea game = new Linea(4, 4, 'A');
        return game;
    }

    private static String drawMatchMessage() {
        return "The game is over, its a draw";
    }

    private static String theGameIsOverMessage() {
        return "The game is over";
    }


    private void assertThrowsLike( Executable executable, String message) {
        assertEquals( message,
                assertThrows( RuntimeException.class, executable ).getMessage() );
    }

    public Linea playList(Linea game, List<Integer> plays) {
        for (int i = 0; i < plays.size(); i++) {
            if (i % 2 == 0) {
                game.playRedAt(plays.get(i));
            } else {
                game.playBlueAt(plays.get(i));
            }
        }
        return game;
    }

}
