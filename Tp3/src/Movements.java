import java.util.List;

public abstract class Movements {

    public abstract String turnRight(String actualDirection);

    public abstract String turnLeft(String actualDirection);

    public abstract List<Integer> forward(String actualDirection, List<Integer> actualPosition);

    public abstract List<Integer> down(List<Integer> actualPosition);

    public abstract List<Integer> up(List<Integer> actualPosition);

//    public abstract String releaseBrownie(String actualStatusBrownie);



}
