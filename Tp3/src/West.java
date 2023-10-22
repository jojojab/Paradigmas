import java.util.Arrays;
import java.util.List;

public class West extends Movements {
    public Integer turnRight() {
        return 3;
    }

    public Integer turnLeft() {
        return 1;
    }

    public List<Integer> forward(List<Integer> actualPosition) {
        return Arrays.asList(actualPosition.get(0) - 1, actualPosition.get(1), actualPosition.get(2));
    }

    public List<Integer> down(Nemo nemo) {
        return nemo.depthManager.down(nemo);
    }

    public List<Integer> up(Nemo nemo) {
        return nemo.depthManager.up(nemo);
    }

    public String direction() {
        return "West";
    }

    public String releaseBrownie(Nemo nemo) {
        return nemo.depthManager.releaseBrownie(nemo);
    }
}
