import java.util.Arrays;
import java.util.List;

public class Nemo {

    public MovementsManager movementsManager = new MovementsManager(this);
    public CommandsManager commandsManager = new CommandsManager();
    public DepthManager depthManager = new DepthManager();

    public Nemo() {
        movementsManager.setPosition(posX(), posY(), altitude());
    }

    public List<Integer> position() {
        return movementsManager.position;
    }

    public Integer posX() {
        return movementsManager.position.get(0);
    }

    public Integer posY() {
        return movementsManager.position.get(1);
    }

    public Integer altitude() {
        return movementsManager.position.get(2);
    }

    public String direction() {
        return movementsManager.direction();
    }

    public String statusBrownie() {
        return movementsManager.statusBrownie();
    }

    public void move(String movements) {
        Arrays.stream(movements.split("")).forEach(move -> commandsManager.executeCommands(move, this));
    }
}
