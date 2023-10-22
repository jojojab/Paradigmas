import java.util.ArrayList;
import java.util.List;

public class DepthManager {

    public ArrayList<Depth> depths = new ArrayList<Depth>();
    public List<Integer> position = List.of(0, 0, 0);

    {
        depths.add(new Surface());
    }

    public List<Integer> up(Nemo nemo) {
        position = depths.get(0).up(nemo);
        depths = depths.get(0).afterUp(depths);
        return position;
    }

    public List<Integer> down(Nemo nemo) {
        position = depths.get(0).down(nemo);
        depths.add(0, depths.get(0).afterDown());
        return position;
    }

    public String releaseBrownie(Nemo nemo) {
        return depths.get(0).releaseBrownie(nemo);
    }
}
