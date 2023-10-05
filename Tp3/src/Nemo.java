import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class Nemo {

    private List<Integer> position = new ArrayList<>();
    {
        position = Arrays.asList(0,0);
    }
    private Integer altitude = 0;
    private Integer direction = 0;
    public Nemo ( ) {
    }

    public List<Integer> position() { return position; }
    public Integer posX() { return position.get(0); }
    public Integer posY() { return position.get(1); }
    public Integer altitude() { return altitude; }
    public Integer direction() { return direction; }
}
