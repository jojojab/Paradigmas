import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nemo {

    private List<Integer> position = new ArrayList<>();
    {
        position = Arrays.asList(0,0,0);
    }
    public String direction = "East";
    private String statusBrownie = "Brownie not released";
    public ArrayList<Movements> movementsDirection = new ArrayList<>();
    {
        movementsDirection.add(new East());
        movementsDirection.add(new South());
        movementsDirection.add(new West());
        movementsDirection.add(new North());
    }

    public List<Integer> position() { return position; }
    public Integer posX() { return position.get(0); }
    public Integer posY() { return position.get(1); }
    public Integer altitude() { return position.get(2); }
    public String direction() { return direction; }
    public String statusBrownie() { return statusBrownie; }
    public Integer actualDirection = 0;

    public Nemo move(String moves ) {
        for (String move : moves.split("")) {
            switch (move) {
                case "d":
                    position = movementsDirection.get(0).down(position);
                    break;
                case "u":
                    if (altitude() < 0) {
                        position = movementsDirection.get(actualDirection).up(position);
                    }
                    break;
                case "l":
                    direction = movementsDirection.get(actualDirection).turnLeft(direction);
                    actualDirection = (4 + actualDirection - 1) % 4;
                    break;
                case "r":
                    direction = movementsDirection.get(actualDirection).turnRight(direction);
                    actualDirection = (actualDirection + 1) % 4;
                    break;
                case "f":
                    position = movementsDirection.get(actualDirection).forward(direction, position);
                    break;
                case "m":
                    statusBrownie = releaseBrownie();
                    break;
            }
        }
        return this;
    }
    public String releaseBrownie(){
        if (altitude() >= -1) {
            return "Incredible Chocolate Brownie Moment has been released unharmed";
        }
        throw new RuntimeException("Nemo has been destroyed, Reason: trying to release brownie below the first level");
    }
}
