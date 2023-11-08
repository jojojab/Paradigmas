package linea;

import org.junit.Test;

public class GameTest {

    @Test
    public void createEmptyBoard() {
        Linea game = new Linea(4, 4, 'A');
        assert game.show().equals("||....||\n||....||\n||....||\n||....||\n------");
    }
}
