import java.util.List;

public abstract class Movements {

    public abstract Integer turnRight();

    public abstract Integer turnLeft();

    public abstract List<Integer> forward(List<Integer> actualPosition);

    public abstract List<Integer> down(Nemo nemo);

    public abstract List<Integer> up(Nemo nemo);

    public abstract String releaseBrownie(Nemo nemo);

    public abstract String direction();


}
