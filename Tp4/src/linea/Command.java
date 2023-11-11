package linea;

import java.util.List;

public class Command {

    static public GameMode commandFor(char command ) {
        return List.of( new Command( 'A', new ModeA()),
                        new Command( 'B', new ModeB()),
                        new Command( 'C', new ModeC() )
                ).stream()
                .filter( each -> each.applies( command ) )
                .findAny()
                .get().action;
    }
    protected char key;
    private GameMode action;

    public Command( char aKey, GameMode anAction ) {
        key = aKey;
        action = anAction;
    }

    public boolean applies( char command ) { return key == command; }
}