import java.util.ArrayList;

public class CommandsManager {

    public CommandsManager(Nemo nemo){

    }

    public ArrayList<Commands> commands = new ArrayList<>();
    {
        commands.add(new Down());
        commands.add(new Up());
        commands.add(new Left());
        commands.add(new Right());
        commands.add(new Forward());
//        commands.add(new Release());
    }

    public void executeCommands(String command, Nemo nemo) {
        commands.stream().filter(c -> c.isCommand(command)).forEach(c -> c.execute(nemo));
    }
}
