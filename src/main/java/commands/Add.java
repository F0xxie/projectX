package commands;

import utils.DBService;

public class Add extends Command {
    private DBService dbService = new DBService();

    @Override
    public void execute(String[] args) {
        switch (args[0]) {
            case "user": {
                this.dbService.addUser(args);
                break;
            }
            case "content": {
                this.dbService.addContent(args);
                break;
            }
            case "type": {
                this.dbService.addType(args);
                break;
            }
            case "image": {
                this.dbService.addImage(args);
                break;
            }
            case "vote": {
                this.dbService.addVote(args);
            }
        }
    }
}