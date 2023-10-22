public class Left extends Commands {

    public boolean isCommand(String command) {
        return command.equals("l");
    }

    public void execute(Nemo nemo) {
        nemo.movementsManager.turnLeft();
    }
}
