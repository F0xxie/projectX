package commands;

import utils.DBService;

public class Add extends Command {
    private DBService dbService = new DBService();

    @Override
    public void execute(String[] args) {
        switch (args[0]) {
            case "user":
                this.dbService.addUser(args);
                break;
            case "type":
                this.dbService.addContent(args);
                break;
            }
        }
    }