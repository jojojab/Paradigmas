import java.util.Arrays;
import java.util.List;

public class South extends Movements {

    public Integer turnRight() {
        return 2; }

    public Integer turnLeft() {
        return 0; }

    public List<Integer> forward(String actualDirection, List<Integer> actualPosition) {
        return Arrays.asList(actualPosition.get(0), actualPosition.get(1) - 1, actualPosition.get(2));
    }

    public List<Integer> down(List<Integer> actualPosition) {
        return Arrays.asList(actualPosition.get(0), actualPosition.get(1), actualPosition.get(2) - 1);
    }

    public List<Integer> up(List<Integer> actualPosition) {
        return Arrays.asList(actualPosition.get(0), actualPosition.get(1), actualPosition.get(2) + 1);
    }

    public String direction(){
        return "South"; }

//    public String releaseBrownie(String actualStatusBrownie) {
//        return "Brownie released";
//    }
}
