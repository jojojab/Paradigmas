import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Surface extends Depth {

    public List<Integer> up(Nemo nemo) {
        return Arrays.asList(nemo.posX(), nemo.posY(), nemo.altitude());
    }

    public List<Integer> down(Nemo nemo) {
        return Arrays.asList(nemo.posX(), nemo.posY(), nemo.altitude() - 1);
    }

    public ArrayList<Depth> afterUp(ArrayList<Depth> depths) {
        return depths;
    }

    public Depth afterDown() {
        return new Deep();
    }

    public String releaseBrownie(Nemo nemo) {
        return "Incredible Chocolate Brownie Moment has been released unharmed";
    }
}
