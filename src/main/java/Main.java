import commands.Add;
import commands.Command;
import commands.Exit;
import commands.Remove;
import commands.Show;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Scanner;
import utils.MyDBController;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        MyDBController myDBController = new MyDBController();
        myDBController.connect();
        Scanner in = new Scanner(System.in);
        map.put("create", new Add());
        map.put("remove", new Remove());
        map.put("delete", new Remove());
        map.put("add", new Add());
        map.put("show", new Show());
        map.put("exit", new Exit());
        do {
            System.out.print(">");
            String command = in.nextLine();
            String[] commands = command.split(" ");
            if (!map.containsKey(commands[0])) continue;
            Command c = (Command)map.get(commands[0]);

            if (commands.length == 1) {
                c.execute();
                continue;
            }
            String[] commArgs = new String[commands.length - 1];
            System.arraycopy(commands, 1, commArgs, 0, commands.length - 1);

            c.execute(commArgs);
        } while (true);
    }
}