import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class Nemo {

    private List<Integer> position = new ArrayList<>();
    {
        position = Arrays.asList(0,0,0);
    }
    private Integer direction = 0;
    private String statusBrownie = "Brownie not released";

//    public Nemo ( ) {
//    }

    public List<Integer> position() { return position; }
    public Integer posX() { return position.get(0); }
    public Integer posY() { return position.get(1); }
    public Integer altitude() { return position.get(2); }
    public Integer direction() { return direction; }
    public String statusBrownie() { return statusBrownie; }

    public void move(String moves ) {
        for (String move : moves.split("")) {
            switch (move) {
                case "d":
                    position = Arrays.asList(posX(), posY(), altitude() - 1);
                    break;
                case "u":
                    if (altitude() < 0) {
                        position = Arrays.asList(posX(), posY(), altitude() + 1);
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
                        position = Arrays.asList(posX() + 1, posY(), altitude());
                    } else if (direction == 90) {
                        position = Arrays.asList(posX(), posY() + 1, altitude());
                    } else if (direction == 180) {
                        position = Arrays.asList(posX() - 1, posY(), altitude());
                    } else if (direction == 270) {
                        position = Arrays.asList(posX(), posY() - 1, altitude());
                    }
                    break;
                case "m":
                    statusBrownie = releaseBrownie();
                    break;
            }
        }
    }
    public String releaseBrownie(){
        if (altitude() >= -1) {
            return "Incredible Chocolate Brownie Moment has been released unharmed";
        }
        throw new RuntimeException("Nemo has been destroyed, Reason: trying to release brownie below the first level");
    }
}
