import java.util.List;

public abstract class Movements {

    public abstract Integer turnRight();

    public abstract Integer turnLeft();

    public abstract List<Integer> forward(String actualDirection, List<Integer> actualPosition);

    public abstract List<Integer> down(List<Integer> actualPosition);

    public abstract List<Integer> up(List<Integer> actualPosition);

//    public abstract String releaseBrownie(String actualStatusBrownie);

    public abstract String direction();


}
