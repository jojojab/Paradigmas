import java.util.Arrays;
import java.util.List;

public class East extends Movements{

    public String turnRight(String actualDirection) {
        return "South";
    }

    public String turnLeft(String actualDirection) {
        return "North";
    }

    public List<Integer> forward(String actualDirection, List<Integer> actualPosition) {
        return Arrays.asList(actualPosition.get(0) + 1, actualPosition.get(1), actualPosition.get(2));
    }

    public List<Integer> down(List<Integer> actualPosition) {
        return Arrays.asList(actualPosition.get(0), actualPosition.get(1), actualPosition.get(2) - 1);
    }

    public List<Integer> up(List<Integer> actualPosition) {
        return Arrays.asList(actualPosition.get(0), actualPosition.get(1), actualPosition.get(2) + 1);
    }

//    public String releaseBrownie(String actualStatusBrownie) {
//        return "Brownie released";
//    }
}
