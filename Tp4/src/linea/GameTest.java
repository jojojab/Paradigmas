package linea;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static linea.Linea.noEsTurnoErrorDescription;

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
        game.playRedAt(1);
        assertEquals(noEsTurnoErrorDescription, game.show());
    }

    @Test
    public void bluePlayerCanNotStart(){
        Linea game = new Linea(4, 4, 'C');
        game.playBlueAt(0);
        assertEquals(noEsTurnoErrorDescription, game.show());
    }
}
