public class Right extends Commands {
    public boolean isCommand(String command) {
        return command.equals("r");
    }

    public void execute(Nemo nemo) {
        nemo.movementsManager.turnRight();
    }
}
