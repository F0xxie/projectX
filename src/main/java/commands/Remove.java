package commands;

import utils.DBService;

public class Remove extends Command {
    private DBService dbService = new DBService();

    @Override
    public void execute(String[] args) {
        if (args[0].equals("user") && args.length == 2) {
            this.dbService.removeUser(args);
        }
        if (args[0].equals("content") && args.length == 2) {
            this.dbService.removeContent(args);
        }
        if (args[0].equals("type") && args.length == 2) {
            this.dbService.removeType(args);
        }
        if (args[0].equals("image") && args.length == 2) {
            this.dbService.removeImage(args);
        }
        if (args[0].equals("vote") && args.length == 3) {
            this.dbService.removeVote(args);
        }
    }
}