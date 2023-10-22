import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovementsManager {

    public MovementsManager(Nemo nemo) {

    }

    public List<Integer> position = new ArrayList<>();
    {
        position = Arrays.asList(0,0,0);
    }
    public Integer actualDirection = 0;

    public void setPosition(int x, int y, int z) {
        position = Arrays.asList(x,y,z);
    }

    public String direction() { return movementsDirection.get(actualDirection).direction(); }

    public ArrayList<Movements> movementsDirection = new ArrayList<>();
    {
        movementsDirection.add(new East());
        movementsDirection.add(new South());
        movementsDirection.add(new West());
        movementsDirection.add(new North());
    }

    public void turnRight() {
        actualDirection =  movementsDirection.get(actualDirection).turnRight();
    }

    public void turnLeft() {
        actualDirection = movementsDirection.get(actualDirection).turnLeft();
    }

    public void forward() {
        position = movementsDirection.get(actualDirection).forward(movementsDirection.get(actualDirection).direction(), position);
    }

    public void down() {
        position =  movementsDirection.get(actualDirection).down(position);
    }

    public void up() {
        position = movementsDirection.get(actualDirection).up(position);
    }

//    public String releaseBrownie(String actualStatusBrownie) {
//        return movementsDirection.get(actualDirection).releaseBrownie(actualStatusBrownie);
//    }



}
