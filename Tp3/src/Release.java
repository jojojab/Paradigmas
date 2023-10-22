public class Release extends Commands {

    public boolean isCommand(String command) {
        return command.equals("m");
    }

    public void execute(Nemo nemo) {
        nemo.movementsManager.releaseBrownie();
    }
}
