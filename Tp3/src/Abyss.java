import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Abyss extends Depth {

    public List<Integer> up(Nemo nemo) {
        return Arrays.asList(nemo.posX(), nemo.posY(), nemo.altitude() + 1);
    }

    public List<Integer> down(Nemo nemo) {
        return Arrays.asList(nemo.posX(), nemo.posY(), nemo.altitude() - 1);
    }

    public ArrayList<Depth> afterUp(ArrayList<Depth> depths) {
        depths.remove(0);
        return depths;
    }

    public Depth afterDown() {
        return new Abyss();
    }

    public String releaseBrownie(Nemo nemo) {
        throw new RuntimeException("Nemo has been destroyed, Reason: trying to release brownie below the first level");
    }
}
