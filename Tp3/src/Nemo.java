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

    public void move(String moves ) {
        for (String move : moves.split("")) {
            switch (move) {
                case "d":
                    altitude--;
                    break;
                case "u":
                    if (altitude < 0) {
                        altitude++;
                    }
                    break;
                case "l":
                    direction = (direction + 90) % 360;
                    break;
                case "r":
                    if ((direction - 90) < 0) {
                        direction = 270;
                    } else {
                        direction = direction - 90;
                    }
                    break;
                case "f":
                    if (direction == 0) {
                        position = Arrays.asList(posX() + 1, posY());
                    } else if (direction == 90) {
                        position = Arrays.asList(posX(), posY() + 1);
                    } else if (direction == 180) {
                        position = Arrays.asList(posX() - 1, posY());
                    } else if (direction == 270) {
                        position = Arrays.asList(posX(), posY() - 1);
                    }
                    break;
                case "m":
                    liberar();
                    break;
            }
        }
    }
    public void liberar(){
    }
}
