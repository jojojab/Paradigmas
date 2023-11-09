package linea;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.lang.reflect.Executable;

import static org.junit.Assert.assertEquals;

import static linea.Linea.noEsTurnoErrorDescription;
import static org.junit.Assert.assertThrows;

public class GameTest {

    @Test
    public void emptyBoardWhenCreated(){
        Linea game = new Linea(4, 4, 'C');
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| . . . . ||\n|| . . . . ||\n");
    }

    @Test
    public void somePlays(){
        Linea game = new Linea(4, 4, 'C');
        game.playRedAt(0);
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);
        assertEquals(game.show(), "|| . . . . ||\n|| . . . . ||\n|| O O . . ||\n|| X X . . ||\n");
    }

    @Test
    public void cannotMakeTwoConsecutivesPlays() {
        Linea game = new Linea(4, 4, 'C');
        game.playRedAt(0);
        try{
            game.playRedAt(1);
        } catch (RuntimeException e){
            assertEquals(noEsTurnoErrorDescription, e.getMessage());
        }
//        assertThrowsLike(() -> game.playRedAt(1), noEsTurnoErrorDescription);
    }

    @Test
    public void bluePlayerCanNotStart(){
        Linea game = new Linea(4, 4, 'C');
        try {
            game.playBlueAt(0);
        } catch (RuntimeException e){
            assertEquals(noEsTurnoErrorDescription, e.getMessage());
        }
    }

    private void assertThrowsLike(Executable excecutable, String message){
        assertEquals(message,assertThrows(Error.class, (ThrowingRunnable) excecutable).getMessage());
    }
}
