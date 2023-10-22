import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nemo {

    public MovementsManager movementsManager = new MovementsManager(this);
    public CommandsManager commandsManager = new CommandsManager(this);
    private String statusBrownie = "Brownie not released";

    public List<Integer> position() { return movementsManager.position; }
    public Integer posX() { return movementsManager.position.get(0); }
    public Integer posY() { return movementsManager.position.get(1); }
    public Integer altitude() { return movementsManager.position.get(2); }
    public String direction() { return movementsManager.direction(); }
    public String statusBrownie() { return statusBrownie; }

    public void move(String movements){
        Arrays.stream(movements.split("")).forEach(move -> commandsManager.executeCommands(move, this));
    }

    public String releaseBrownie(){
        if (altitude() >= -1) {
            return "Incredible Chocolate Brownie Moment has been released unharmed";
        }
        throw new RuntimeException("Nemo has been destroyed, Reason: trying to release brownie below the first level");
    }
}
