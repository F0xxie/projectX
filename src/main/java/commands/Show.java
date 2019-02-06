package commands;

import utils.DBService;

public class Show extends Command {
    private DBService dbService = new DBService();

    @Override
    public void execute(String[] args) {
        try {
            if (args[0].equals("users")) { this.dbService.getUsers(); }
            if (args[0].equals("types")) { this.dbService.getContent(); }
            //actually unused
            if (args[0].equals("content")) { System.out.println("Content"); }
            if (args[0].equals("images")) { System.out.println("Images"); }
            if (args[0].equals("votes")) { System.out.println("Votes"); }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}