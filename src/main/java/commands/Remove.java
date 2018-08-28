package commands;

import utils.DBService;

public class Remove extends Command {
    private DBService dbService = new DBService();

    @Override
    public void execute(String[] args) {
        switch (args[0]) {
            case "user":
                this.dbService.removeUser(args);
                break;
            case "content":
                this.dbService.removeContent(args);
                break;
            case "type":
                this.dbService.removeType(args);
                break;
            case "image":
                this.dbService.removeImage(args);
                break;
            case "vote": {
                this.dbService.removeVote(args);
                break;
            }
        }
    }
}