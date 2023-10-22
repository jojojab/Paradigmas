import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovementsManager {

    public String statusBrownie = "Brownie not released";
    public List<Integer> position;
    public Integer actualDirection = 0;
    public ArrayList<Movements> movementsDirection = new ArrayList<>();
    private final Nemo nemo;

    {
        position = Arrays.asList(0, 0, 0);
    }

    {
        movementsDirection.add(new East());
        movementsDirection.add(new South());
        movementsDirection.add(new West());
        movementsDirection.add(new North());
    }

    public MovementsManager(Nemo nemo) {
        this.nemo = nemo;
    }

    public void setPosition(int x, int y, int z) {
        position = Arrays.asList(x, y, z);
    }

    public String direction() {
        return movementsDirection.get(actualDirection).direction();
    }

    public String statusBrownie() {
        return statusBrownie;
    }

    public void turnRight() {
        actualDirection = movementsDirection.get(actualDirection).turnRight();
    }

    public void turnLeft() {
        actualDirection = movementsDirection.get(actualDirection).turnLeft();
    }

    public void forward() {
        position = movementsDirection.get(actualDirection).forward(position);
    }

    public void down() {
        position = movementsDirection.get(actualDirection).down(nemo);
    }

    public void up() {
        position = movementsDirection.get(actualDirection).up(nemo);
    }

    public void releaseBrownie() {
        statusBrownie = movementsDirection.get(actualDirection).releaseBrownie(nemo);
    }
}
