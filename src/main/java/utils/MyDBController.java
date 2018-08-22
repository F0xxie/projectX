package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyDBController {
    private Statement statement;
    private Connection connection;

    public Connection connect() {
        try {
            Class.forName("org.h2.Driver");
            this.connection = DriverManager.getConnection("jdbc:h2:file:E:/data/sample", "sa", "");
            this.statement = this.connection.createStatement();
        }
        catch (Exception e) {
            System.out.println("Can't connect to DB: " + e.toString());
        }
        return this.connection;
    }

    public ResultSet inquiryWithResult(String str) {
        try {
            ResultSet rs = this.statement.executeQuery(str);
            return rs;
        }
        catch (Exception e) {
            System.out.println("Can't handle inquiry: " + e.toString());
            return null;
        }
    }

    public void inquiry(String str) {
        try {
            this.statement.execute(str);
        }
        catch (Exception E) {
            System.out.println("Can't handle inquiry");
        }
    }
}