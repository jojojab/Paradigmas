import java.util.ArrayList;
import java.util.List;

public abstract class Depth {

    public abstract List<Integer> up(Nemo nemo);

    public abstract List<Integer> down(Nemo nemo);

    public abstract ArrayList<Depth> afterUp(ArrayList<Depth> depths);

    public abstract Depth afterDown();

    public abstract String releaseBrownie(Nemo nemo);
}
