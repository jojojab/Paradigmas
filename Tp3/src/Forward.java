public class Forward extends Commands {
    public boolean isCommand(String command) {
        return command.equals("f");
    }

    public void execute(Nemo nemo) {
        nemo.movementsManager.forward();
    }
}
