public class Up extends Commands {
    public boolean isCommand(String command) {
        return command.equals("u");
    }

    public void execute(Nemo nemo) {
        nemo.movementsManager.up();
    }
}