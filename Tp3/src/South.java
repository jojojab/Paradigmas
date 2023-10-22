import java.util.Arrays;
import java.util.List;

public class South extends Movements {
    public Integer turnRight() {
        return 2;
    }

    public Integer turnLeft() {
        return 0;
    }

    public List<Integer> forward(List<Integer> actualPosition) {
        return Arrays.asList(actualPosition.get(0), actualPosition.get(1) - 1, actualPosition.get(2));
    }

    public List<Integer> down(Nemo nemo) {
        return nemo.depthManager.down(nemo);
    }

    public List<Integer> up(Nemo nemo) {
        return nemo.depthManager.up(nemo);
    }

    public String direction() {
        return "South";
    }

    public String releaseBrownie(Nemo nemo) {
        return nemo.depthManager.releaseBrownie(nemo);
    }
}
