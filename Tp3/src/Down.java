public class Down extends Commands {
    public boolean isCommand(String command) {
        return command.equals("d");
    }

    public void execute(Nemo nemo) {
        nemo.movementsManager.down();
    }
}
