package linea;

import org.junit.Test;

import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static linea.Linea.noEsTurnoErrorDescription;


public class GameTest {

    @Test
    public void emptyBoardWhenCreated(){
        Linea game = new Linea(4, 4, 'C');
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| . . . . ||\n|| . . . . ||\n|| 0 1 2 3 ||");
    }

    @Test
    public void somePlays(){
        Linea game = new Linea(4, 4, 'C');
        game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O . . ||\n|| X X . . ||\n|| 0 1 2 3 ||");
    }

    @Test
    public void cannotMakeTwoConsecutivesPlays() {
        Linea game = new Linea(4, 4, 'C');
        game.playRedAt(0);
        assertThrowsLike(() -> game.playRedAt(1), noEsTurnoErrorDescription);
    }

    @Test
    public void bluePlayerCanNotStart(){
        Linea game = new Linea(4, 4, 'C');
        assertThrowsLike(() -> game.playBlueAt(0), noEsTurnoErrorDescription);
    }

    private void assertThrowsLike( Executable executable, String message) {
        assertEquals( message,
                assertThrows( RuntimeException.class, executable ).getMessage() );
    }

}
